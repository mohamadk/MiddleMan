package com.mohamadk.middleman

interface Binder<in T> {
    fun bind(item: T?)
}