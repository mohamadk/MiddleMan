package com.mohamadk.globaladapter.adapter.placeholder

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import com.mohamadk.globaladapter.R
import com.mohamadk.globaladapter.adapter.Binder
import com.mohamadk.globaladapter.adapter.networkstate.NetworkState

open class PlaceHolderView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttributes: Int = 0
) : LinearLayoutCompat(context, attributes, defStyleAttributes)
    , Binder<NetworkState>
    {

        init {
            View.inflate(context, R.layout.placeholder_item,this)
        }

    override fun bind(item: NetworkState?) {

    }


}