package com.mohamadk.globaladapter.adapter.placeholder

import com.mohamadk.globaladapter.adapter.model.BaseModel
import kotlinx.android.parcel.Parcelize

@Parcelize
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