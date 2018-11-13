package com.mohamadk.globaladapter.test.item2

import com.mohamadk.globaladapter.adapter.model.BaseModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class ItemModel2(
    val id: String
    , val title: String
    , val url: String
) : BaseModel {


    override fun defaultResLayout(position: Int): Int? {
        return null
    }

    override fun defaultViewClass(position: Int): Class<*>? {
        return ItemView2::class.java
    }

}
