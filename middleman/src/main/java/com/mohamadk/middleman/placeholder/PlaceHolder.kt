package com.mohamadk.middleman.placeholder

import com.mohamadk.middleman.model.BaseModel


open class PlaceHolder : BaseModel {

    override fun defaultViewClass(position: Int): Class<*>? {
        return PlaceHolderView::class.java
    }

    override fun defaultResLayout(position: Int): Int? {
        return null
    }

    override fun areContentsTheSame(newItem: BaseModel): Boolean {
        return true
    }

    override fun areItemsTheSame(newItem: BaseModel): Boolean {
        return this === newItem
    }
}