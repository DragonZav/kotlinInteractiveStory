package com.christopheraugg.interactivestory.model

/**
 * Created by chrisa on 8/15/17.
 */
data class Page(val imageId:Int, val textId:Int, val choice1:Choice?,
                val choice2:Choice?, val isFinalPage:Boolean=false) {

    constructor(imageId: Int, textId: Int) : this(imageId, textId, null, null, true)
}