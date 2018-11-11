package com.mohamadk.globaladapter

import android.view.View

fun Any?.toVisibility(): Int {
    return if ((this is Boolean && this == true) || (this !is Boolean && this != null)) {
        View.VISIBLE
    } else {
        View.GONE
    }
}