package com.mohamadk.middleman.model

import androidx.annotation.LayoutRes
import com.mohamadk.middleman.model.ModelTypes.types

interface BaseModel : ModelComparator<BaseModel> {
    /**
     * return the corresponding viewType and register it to "types set" if it was not registered before
     */
    fun getViewType(position:Int): ModelType {

        var type = types.find {
            val (_, defaultResLayout, defaultViewClass, modelClass) = it

            defaultViewClass == defaultViewClass(position)
                    && defaultResLayout == defaultResLayout(position)
                    && modelClass == this::class.java

        }

        return if (type != null) {
            type
        } else {
            type = ModelType(
                types.size,
                defaultResLayout(position),
                defaultViewClass(position),
                this::class.java
            )
            types.add(type)
            type
        }
    }

    /**
     * implement this method or "defaultViewClass" in your model to be used in adapter
     */
    @LayoutRes
    fun defaultResLayout(position: Int): Int?

    /**
     * implement this method or "defaultResLayout" in your model to be used in adapter
     */
    fun defaultViewClass(position: Int): Class<*>?

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