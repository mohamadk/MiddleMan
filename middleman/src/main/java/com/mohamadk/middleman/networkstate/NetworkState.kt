package com.mohamadk.middleman.networkstate

import com.mohamadk.middleman.R
import com.mohamadk.middleman.model.BaseModel
import kotlinx.android.parcel.Parcelize

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}


open class NetworkState private constructor(
    val status: Status,
    val msg: String? = null
) : BaseModel {

    override fun defaultViewClass(position: Int): Class<*>? {
        return null
    }

    override fun defaultResLayout(position: Int): Int? {
        return R.layout.network_state_item
    }

    override fun areContentsTheSame(newItem: BaseModel): Boolean {
        return true
    }

    override fun areItemsTheSame(newItem: BaseModel): Boolean {
        return this === newItem
    }

    companion object {
        val LOADED =
            NetworkState(Status.SUCCESS)
        val LOADING =
            NetworkState(Status.RUNNING)
        fun error(msg: String?) =
            NetworkState(Status.FAILED, msg)
    }

    override fun equals(other: Any?): Boolean {
        return other is NetworkState && other.status == this.status && this.msg == other.msg
    }
}

