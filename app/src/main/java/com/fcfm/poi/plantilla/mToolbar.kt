package com.fcfm.poi.plantilla

import androidx.appcompat.app.AppCompatActivity

class MyToolbar {
    fun show(activities: AppCompatActivity, title: String, upButton: Boolean)
    {
        activities.setSupportActionBar(activities.findViewById(R.id.id_toolbar))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}