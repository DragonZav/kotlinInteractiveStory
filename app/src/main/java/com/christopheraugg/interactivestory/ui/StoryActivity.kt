package com.christopheraugg.interactivestory.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.christopheraugg.interactivestory.R

class StoryActivity : AppCompatActivity() {

    val TAG = StoryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        var name: String? = getIntent().getStringExtra(getString(R.string.key_name))
        if (name.isNullOrEmpty()) name = "Earthling"
        Log.d(TAG, name)

    }
}
