package com.mohamadk.globaladapter.adapter.networkstate

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import com.mohamadk.globaladapter.adapter.Binder
import com.mohamadk.globaladapter.intractors.RequireInteractor
import com.mohamadk.globaladapter.intractors.RetryListener
import com.mohamadk.globaladapter.toVisibility
import kotlinx.android.synthetic.main.network_state_item.view.*

open class NetworkStateView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttributes: Int = 0
) : LinearLayoutCompat(context, attributes, defStyleAttributes)
    , Binder<NetworkState>
    , RequireInteractor<RetryListener> {

    private lateinit var retryListener: RetryListener

    override fun setInteractor(intractor: RetryListener) {
        this.retryListener = intractor
    }

    override fun bind(item: NetworkState?) {
        progress_bar.visibility = (item!!.status == Status.RUNNING).toVisibility()
        retry_button.visibility = (item.status == Status.FAILED).toVisibility()
        error_msg.visibility = (item.msg != null).toVisibility()
        error_msg.text = item.msg

        retry_button.setOnClickListener {
            retryListener.retry()
        }
    }


}