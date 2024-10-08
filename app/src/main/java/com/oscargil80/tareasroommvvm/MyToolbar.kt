package com.oscargil80.tareasroommvvm

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyToolbar {
    @SuppressLint("RestrictedApi")
    fun show(activities : AppCompatActivity, title: String, upButton:Boolean){
        activities.setSupportActionBar(activities.findViewById(R.id.toolbaR))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        activities.supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }
}