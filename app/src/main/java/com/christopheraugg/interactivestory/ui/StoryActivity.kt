package com.christopheraugg.interactivestory.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.christopheraugg.interactivestory.R
import com.christopheraugg.interactivestory.model.Choice
import com.christopheraugg.interactivestory.model.Page
import com.christopheraugg.interactivestory.model.Story
import java.util.*

class StoryActivity : AppCompatActivity() {

    private val story = Story()
    private var name: String = "Earthling"
    private val pageStack = Stack<Int>()
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

        pageStack.push(pageNumber)
        val page = story.getPage(pageNumber)
        var image = ContextCompat.getDrawable(this, page.imageId)
        storyImageView.setImageDrawable(image)

        var pageText = getString(page.textId)
        pageText = String.format(pageText, name)
        storyTextView.setText(pageText)

        if (page.isFinalPage) {

            choice1Button.visibility = View.INVISIBLE
            choice2Button.setText(getString(R.string.play_again_button_text))
            choice2Button.setOnClickListener {

                loadPage(0)
            }


        } else {

            loadButtons(page)
        }
    }

    private fun loadButtons(page: Page) {
        choice1Button.visibility = View.VISIBLE
        choice1Button.setText(page.choice1!!.textId)
        choice1Button.setOnClickListener {
            var nextPage = page.choice1!!.nextPage
            loadPage(nextPage)
        }

        choice2Button.visibility = View.VISIBLE
        choice2Button.setText(page.choice2!!.textId)
        choice2Button.setOnClickListener {
            var nextPage = page.choice2!!.nextPage
            loadPage(nextPage)
        }
    }

    override fun onBackPressed() {
        pageStack.pop()
        if (pageStack.isEmpty()) {
            super.onBackPressed()
        } else {
            loadPage(pageStack.pop())
        }

    }
}
