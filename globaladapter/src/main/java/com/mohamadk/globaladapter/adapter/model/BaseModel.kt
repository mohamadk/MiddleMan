package com.mohamadk.globaladapter.adapter.model

import android.os.Parcelable
import androidx.annotation.LayoutRes
import com.mohamadk.globaladapter.adapter.model.ModelTypes.types

interface BaseModel : ModelComparator<BaseModel>, Parcelable {

    fun getViewType(): ModelType {

        var type = types.find {
            val (_, defaultResLayout, defaultViewClass, modelClass) = it

            defaultViewClass == defaultViewClass()
                    && defaultResLayout == defaultResLayout()
                    && modelClass == this::class.java

        }

        return if (type != null) {
            type
        } else {
            type = ModelType(types.size, defaultResLayout(), defaultViewClass(), this::class.java)
            types.add(type)
            type
        }
    }

    /**
     * implement this method or "defaultView" in your model to be used in adapter
     */
    @LayoutRes
    fun defaultResLayout(): Int?

    /**
     * implement this method or "defaultResLayout" in your model to be used in adapter
     */
    fun defaultViewClass(): Class<*>?

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