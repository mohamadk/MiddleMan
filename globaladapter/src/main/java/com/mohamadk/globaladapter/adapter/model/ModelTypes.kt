package com.mohamadk.globaladapter.adapter.model

object ModelTypes {
    val types:MutableSet<ModelType> = mutableSetOf()
}

data class ModelType(
     val type:Int
    ,val defaultResLayout:Int?
    ,val defaultViewClass:Class<*>?
    ,val modelClass:Class<*>
)