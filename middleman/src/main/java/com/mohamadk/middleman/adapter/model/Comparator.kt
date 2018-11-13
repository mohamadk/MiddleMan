package com.mohamadk.middleman.adapter.model

import androidx.recyclerview.widget.DiffUtil

class Comparator<MODEL : ModelComparator<MODEL>> : DiffUtil.ItemCallback<MODEL>() {
    override fun areContentsTheSame(oldItem: MODEL, newItem: MODEL): Boolean =
            oldItem.areContentsTheSame(newItem)

    override fun areItemsTheSame(oldItem: MODEL, newItem: MODEL): Boolean =
            oldItem.areItemsTheSame(newItem)
}
