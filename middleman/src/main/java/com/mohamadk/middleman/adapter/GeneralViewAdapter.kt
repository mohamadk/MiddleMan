package com.mohamadk.middleman.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamadk.middleman.AdapterProvider
import com.mohamadk.middleman.GlobalViewHolder
import com.mohamadk.middleman.model.BaseModel
import com.mohamadk.middleman.networkstate.NetworkState
import com.mohamadk.middleman.intractors.BaseIntractor
import com.mohamadk.middleman.intractors.RequireInteractor

open class GeneralViewAdapter(
    private val interact: BaseIntractor? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    , AdapterProvider<List<BaseModel>> {

    private var networkState: NetworkState? = null
    var items: MutableList<BaseModel> = mutableListOf()
    var inflater: LayoutInflater? = null

    private fun isNetworkStateView(position: Int) =
        (hasExtraRow() && position == itemCount - 1)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }

        val itemView= createItemView(
            viewType
            , inflater!!
            , parent
        )

        if (itemView is RequireInteractor<*>) {
            (itemView as RequireInteractor<BaseIntractor>).setInteractor(interact!!)
        }

        return GlobalViewHolder<BaseModel>(itemView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GlobalViewHolder<BaseModel>).bind(
            if (isNetworkStateView(position)) {
                networkState
            } else {
                getItem(position)
            }
        )
    }

    private fun getItem(position: Int): BaseModel {
        return items[position]
    }

    override fun submitList(items: List<BaseModel>?) {
        this.items = items?.toMutableList() ?: mutableListOf()
        notifyDataSetChanged()
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        return this
    }


    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            networkState!!.getViewType(position).type
        } else {
            items[position].getViewType(position).type
        }
    }

    override fun getItemCount(): Int {
        return items.size + if (hasExtraRow()) 1 else 0
    }

    override fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()

        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(items.size)
            } else {
                notifyItemInserted(items.size)
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }


}