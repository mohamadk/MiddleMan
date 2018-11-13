package com.mohamadk.globaladapter.test.item1

import com.mohamadk.globaladapter.adapter.model.BaseModel
import com.mohamadk.globaladapter.test.R
import kotlinx.android.parcel.Parcelize

@Parcelize
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
