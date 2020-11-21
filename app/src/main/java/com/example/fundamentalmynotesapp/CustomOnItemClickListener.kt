package com.example.fundamentalmynotesapp

import android.view.View

class CustomOnItemClickListener(
    private val position: Int,
    private val onItemClickCallback: OnItemClickCallback
) : View.OnClickListener {

    interface OnItemClickCallback {
        fun onItemClicked(view: View, position: Int)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            onItemClickCallback.onItemClicked(view, position)
        }
    }

}