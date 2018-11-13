package com.mohamadk.middleman.adapter

interface Binder<in T> {
    fun bind(item: T?)
}