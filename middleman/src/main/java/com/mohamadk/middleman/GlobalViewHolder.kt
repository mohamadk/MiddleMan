package com.mohamadk.middleman

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GlobalViewHolder<in MODEL>(
        private val itemView1: View
) : RecyclerView.ViewHolder(itemView1) {
    fun bind(item: MODEL?) {
        (itemView1 as Binder<MODEL>).bind(item)
    }
}