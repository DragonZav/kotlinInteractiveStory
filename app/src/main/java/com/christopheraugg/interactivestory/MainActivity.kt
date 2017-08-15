package com.christopheraugg.interactivestory

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }
    }
}
