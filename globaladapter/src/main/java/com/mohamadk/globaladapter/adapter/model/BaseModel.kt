package com.mohamadk.globaladapter.adapter.model

import android.content.Context
import android.os.Parcelable
import android.view.View
import androidx.annotation.LayoutRes

interface BaseModel : ModelComparator<BaseModel>, Parcelable {

    /**
     * implement this method or "defaultView" in your model to be used in adapter
     */
    @LayoutRes
    fun defaultResLayout(): Int?{
        return null
    }

    /**
     * implement this method or "defaultResLayout" in your model to be used in adapter
     */
    fun defaultView(context: Context): View?

    /**
     * implement this and areItemsTheSame method if you using paging adapter
     */
    override fun areContentsTheSame(newItem: BaseModel): Boolean {
        return false
    }

    /**
     * implement this and areContentsTheSame method if you using paging adapter
     */
    override fun areItemsTheSame(newItem: BaseModel): Boolean {
        return false
    }

}