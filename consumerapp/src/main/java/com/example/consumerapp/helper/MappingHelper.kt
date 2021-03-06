package com.example.consumerapp.helper

import android.database.Cursor
import com.example.consumerapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.example.consumerapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.example.consumerapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.example.consumerapp.db.DatabaseContract.NoteColumns.Companion._ID
import com.example.consumerapp.entity.Note

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(_ID))
                val title = getString(getColumnIndexOrThrow(TITLE))
                val description =
                    getString(getColumnIndexOrThrow(DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DATE))
                notesList.add(Note(id, title, description, date))
            }
        }

        return notesList
    }

    fun mapCursorToObject(notesCursor: Cursor?): Note {
        var note = Note()
        notesCursor?.apply {
            moveToFirst()
            val id = getInt(getColumnIndexOrThrow(_ID))
            val title = getString(getColumnIndexOrThrow(TITLE))
            val description = getString(getColumnIndexOrThrow(DESCRIPTION))
            val date = getString(getColumnIndexOrThrow(DATE))
            note = Note(id, title, description, date)
        }
        return note
    }
}