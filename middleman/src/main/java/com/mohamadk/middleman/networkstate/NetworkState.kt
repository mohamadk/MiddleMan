package com.mohamadk.middleman.networkstate

import com.mohamadk.middleman.R
import com.mohamadk.middleman.model.BaseModel

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

/**
 * status ->
 *        RUNNING,
SUCCESS,
FAILED

msg    ->
error message

type   ->
type of loading, (db loading,Api loading) to decide how to handle in UI.
(when networkState class used not for just NetworkStateView)
 *
 */
open class NetworkState private constructor(
    val status: Status,
    val msg: String? = null,
    val type: Int = 0
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

        fun loaded(type: Int = 0): NetworkState {
            return NetworkState(Status.SUCCESS, type = type)
        }

        fun loading(type: Int = 0): NetworkState {
            return NetworkState(Status.RUNNING, type = type)
        }

        val LOADED =
            NetworkState(Status.SUCCESS)
        val LOADING =
            NetworkState(Status.RUNNING)

        fun error(msg: String?, type: Int = 0) =
            NetworkState(Status.FAILED, msg, type)
    }

    override fun equals(other: Any?): Boolean {
        return other is NetworkState && other.status == this.status && this.msg == other.msg
    }
}

