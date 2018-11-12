package com.mohamadk.globaladapter.adapter.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamadk.globaladapter.adapter.AdapterProvider
import com.mohamadk.globaladapter.adapter.GlobalViewHolder
import com.mohamadk.globaladapter.adapter.model.BaseModel
import com.mohamadk.globaladapter.adapter.networkstate.NetworkState
import com.mohamadk.globaladapter.intractors.BaseIntractor
import com.mohamadk.globaladapter.intractors.RequireInteractor

open class GeneralViewAdapter(
    private val interact: BaseIntractor? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    , AdapterProvider<List<BaseModel>> {

    val TAG = "GeneralViewAdapter"

    private var networkState: NetworkState? = null
    var items: List<BaseModel> = listOf()
    var inflater: LayoutInflater? = null

    private fun isNetworkStateView(position: Int, from: String? = null) =
        (hasExtraRow() && position == itemCount - 1).also {
            Log.d(TAG, "position=$position isNetworkStateView=$it networkState=$networkState from=$from")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }

        val itemView=createItemView(
            viewType
            ,inflater!!
            ,parent
        )

        if (itemView is RequireInteractor<*>) {
            (itemView as RequireInteractor<BaseIntractor>).setInteractor(interact!!)
        }

        return GlobalViewHolder<BaseModel>(itemView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GlobalViewHolder<BaseModel>).bind(
            if (isNetworkStateView(position, "onBindViewHolder")) {
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
        this.items = items ?: listOf()
        notifyDataSetChanged()
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        return this
    }


    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            networkState!!.getViewType().type
        } else {
            items[position].getViewType().type
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