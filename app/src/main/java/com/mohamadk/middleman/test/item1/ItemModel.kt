package com.mohamadk.middleman.test.item1

import com.mohamadk.middleman.model.BaseModel
import com.mohamadk.middleman.test.R
import kotlinx.android.parcel.Parcelize


class ItemModel(
    val id: String
    , val name: String
    , val family: String
) : BaseModel {

    override fun defaultViewClass(position: Int): Class<*>? {
        return null
    }

    override fun defaultResLayout(position: Int): Int? {
        return R.layout.item_layout
    }

}
