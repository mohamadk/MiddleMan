package com.mohamadk.globaladapter.test.item2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.mohamadk.globaladapter.adapter.Binder
import com.mohamadk.globaladapter.test.R
import kotlinx.android.synthetic.main.item_layout2.view.*

class ItemView2
@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttributes: Int = 0
) : LinearLayout(context, attributes, defStyleAttributes)
    , Binder<ItemModel2> {

    init {
        View.inflate(context, R.layout.item_layout2, this)
    }

    override fun bind(item: ItemModel2) {
        tv_title.text = item.title
        item.url//todo do something with url ;)
    }

}