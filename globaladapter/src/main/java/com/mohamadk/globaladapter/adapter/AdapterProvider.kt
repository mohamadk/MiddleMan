package com.mohamadk.globaladapter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mohamadk.globaladapter.adapter.networkstate.NetworkState

interface AdapterProvider<in LIST_MODEL> {

    fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>

    fun setNetworkState(newNetworkState: NetworkState?)

    fun submitList(items: LIST_MODEL?) {}


}