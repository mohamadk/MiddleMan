package com.mohamadk.middleman.adapter.placeholder

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import com.mohamadk.middleman.R
import com.mohamadk.middleman.adapter.Binder
import com.mohamadk.middleman.adapter.networkstate.NetworkState

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