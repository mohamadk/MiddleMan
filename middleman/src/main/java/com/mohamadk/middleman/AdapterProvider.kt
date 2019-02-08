package com.mohamadk.middleman

import androidx.recyclerview.widget.RecyclerView
import com.mohamadk.middleman.networkstate.NetworkState

interface AdapterProvider<in LIST_MODEL> {

    fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>

    fun setNetworkState(newNetworkState: NetworkState?)

    fun submitList(items: LIST_MODEL?) {}


}