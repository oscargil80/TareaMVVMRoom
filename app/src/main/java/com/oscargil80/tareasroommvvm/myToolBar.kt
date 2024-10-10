package com.oscargil80.tareasroommvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

class myToolBar {
    @SuppressLint("RestrictedApi")
    fun show(activities : AppCompatActivity, title : String, upButton: Boolean){
        activities.setSupportActionBar(activities.findViewById(R.id.toolBar))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        activities.supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }
}