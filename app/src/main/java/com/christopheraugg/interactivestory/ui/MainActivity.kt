package com.christopheraugg.interactivestory.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.christopheraugg.interactivestory.R

class MainActivity : AppCompatActivity() {

    private lateinit var nameProperty: EditText
    private lateinit var startButtonProperty: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameProperty = findViewById(R.id.nameEditText) as EditText
        startButtonProperty = findViewById(R.id.startButton) as Button

        startButtonProperty.setOnClickListener {
            val name: String = nameProperty.text.toString()
            startStory(name)
        }
    }

    override fun onResume() {
        super.onResume()
        nameProperty.setText("")
    }

    private fun startStory(name:String) {

       val intent = Intent(this, StoryActivity::class.java)
       intent.putExtra(getString(R.string.key_name), name)
       startActivity(intent)
    }
}
