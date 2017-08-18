package com.christopheraugg.interactivestory.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.christopheraugg.interactivestory.R
import com.christopheraugg.interactivestory.model.Page
import com.christopheraugg.interactivestory.model.Story

class StoryActivity : AppCompatActivity() {

    private val story = Story()
    private var name: String = "Earthling"
    lateinit private var storyImageView: ImageView
    lateinit private var storyTextView: TextView
    lateinit private var choice1Button: Button
    lateinit private var choice2Button: Button

    val TAG = StoryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)


        storyImageView = findViewById(R.id.storyImageView) as ImageView
        storyTextView = findViewById(R.id.storyTextView) as TextView
        choice1Button = findViewById(R.id.choice1Button) as Button
        choice2Button = findViewById(R.id.choice2Button) as Button


        name = getIntent().getStringExtra(getString(R.string.key_name))
        if (name.isNullOrEmpty()) name = "Earthling"
        Log.d(TAG, name)
        loadPage(0)

    }

    private fun loadPage(pageNumber: Int) {

        val page = story.getPage(pageNumber)
        val image = ContextCompat.getDrawable(this, page.imageId)
        storyImageView.setImageDrawable(image)

        var pageText = getString(page.textId)
        pageText = String.format(pageText, name)
        storyTextView.setText(pageText)

        choice1Button.setText(page.choice1!!.textId)
        choice2Button.setText(page.choice2!!.textId)





    }
}
