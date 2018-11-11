package com.mohamadk.globaladapter.adapter

interface Binder<in T> {
    fun bind(item: T)
}