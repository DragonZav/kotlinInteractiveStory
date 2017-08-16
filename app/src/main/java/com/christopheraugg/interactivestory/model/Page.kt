package com.christopheraugg.interactivestory.model

/**
 * Created by chrisa on 8/15/17.
 */
data class Page(private var imageId:Int, private var textId:Int,
                private var choice1:Choice?,
                private var choice2:Choice?,
                private var isFinalPage:Boolean=false) {

    constructor(imageId: Int, textId: Int) : this(imageId, textId, null, null, true)
}