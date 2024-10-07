package com.oscargil80.tareasroommvvm

import androidx.appcompat.app.AppCompatActivity

class MyToolbar {
    fun show(activities : AppCompatActivity, title: String, upButton:Boolean){
        activities.setSupportActionBar(activities.findViewById(R.id.toolbaR))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}