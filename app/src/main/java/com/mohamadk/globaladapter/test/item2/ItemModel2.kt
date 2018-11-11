package com.mohamadk.globaladapter.test.item2

import android.content.Context
import android.view.View
import com.mohamadk.globaladapter.adapter.model.BaseModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class ItemModel2(
    val id: String
    , val title: String
    , val url: String
) : BaseModel {

    override fun defaultView(context: Context): View? {
        return ItemView2(context)
    }

}
