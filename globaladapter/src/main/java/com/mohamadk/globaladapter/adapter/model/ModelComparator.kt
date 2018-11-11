package com.mohamadk.globaladapter.adapter.model

interface ModelComparator<in MODEL> {
    fun areContentsTheSame(newItem: MODEL): Boolean
    fun areItemsTheSame(newItem: MODEL): Boolean
}