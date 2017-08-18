package com.christopheraugg.interactivestory.model

import com.christopheraugg.interactivestory.R

/**
 * Created by chrisa on 8/15/17.
 */
class Story {

    private val _pages = Array(7) {i -> Page(i, i)  }

    init {

        _pages[0] = Page(R.drawable.page0,
                R.string.page0,
                Choice(R.string.page0_choice1, 1),
                Choice(R.string.page0_choice2,2))

        _pages[1] = Page(R.drawable.page1,
                R.string.page1,
                Choice(R.string.page1_choice1, 3),
                Choice(R.string.page1_choice2,4))

        _pages[2] = Page(R.drawable.page2,
                R.string.page2,
                Choice(R.string.page2_choice1, 4),
                Choice(R.string.page2_choice2,6))

        _pages[3] = Page(R.drawable.page3,
                R.string.page3,
                Choice(R.string.page3_choice1, 4),
                Choice(R.string.page3_choice2,5))

         _pages[4] = Page(R.drawable.page4,
                R.string.page4,
                Choice(R.string.page4_choice1, 5),
                Choice(R.string.page4_choice2,6))

         _pages[5] = Page(R.drawable.page5, R.drawable.page5)

         _pages[6] = Page(R.drawable.page6, R.drawable.page6)

    }

    fun getPage(pageNumber: Int): Page {
        if (pageNumber <= _pages.size) {
            return _pages[pageNumber]
        }
        return _pages[0]
    }

}