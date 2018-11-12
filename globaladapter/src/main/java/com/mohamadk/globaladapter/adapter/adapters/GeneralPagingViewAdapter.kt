package com.mohamadk.globaladapter.adapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohamadk.globaladapter.adapter.AdapterProvider
import com.mohamadk.globaladapter.adapter.GlobalViewHolder
import com.mohamadk.globaladapter.adapter.model.BaseModel
import com.mohamadk.globaladapter.adapter.model.Comparator
import com.mohamadk.globaladapter.adapter.networkstate.NetworkState
import com.mohamadk.globaladapter.intractors.BaseIntractor
import com.mohamadk.globaladapter.intractors.RequireInteractor

open class GeneralPagingViewAdapter(
    comparator: Comparator<BaseModel> = Comparator()
    , private val intractor: BaseIntractor? = null
) : PagedListAdapter<BaseModel, RecyclerView.ViewHolder>(comparator)
    , AdapterProvider<PagedList<BaseModel>> {

    private var networkState: NetworkState? = null
    var inflater: LayoutInflater? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GlobalViewHolder<BaseModel>).bind(
            if (isNetworkStateView(position)) {
                networkState
            } else {
                getItem(position)
            }
        )
    }

    private fun isNetworkStateView(position: Int) = hasExtraRow() && position == itemCount - 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }

        val itemView: View = createItemView(
            viewType
            ,inflater!!
            , parent
        )

        if (itemView is RequireInteractor<*>) {
            (itemView as RequireInteractor<BaseIntractor>).setInteractor(intractor!!)
        }

        return GlobalViewHolder<BaseModel>(itemView)
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            networkState!!.getViewType().type
        } else {
            getItem(position)!!.getViewType().type
        }
    }

    override fun submitList(items: PagedList<BaseModel>?) {
        super<PagedListAdapter>.submitList(items)
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        return this
    }

    override fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }
}