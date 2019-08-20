package com.mohamadk.middleman.model

object ModelTypes {
    @JvmStatic
    val types:MutableSet<ModelType> = mutableSetOf()
}

data class ModelType(
     val type:Int
    ,val defaultResLayout:Int?
    ,val defaultViewClass:Class<*>?
    ,val modelClass:Class<*>
)