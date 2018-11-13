package com.mohamadk.middleman.adapter.model

interface ModelComparator<in MODEL> {
    fun areContentsTheSame(newItem: MODEL): Boolean
    fun areItemsTheSame(newItem: MODEL): Boolean
}