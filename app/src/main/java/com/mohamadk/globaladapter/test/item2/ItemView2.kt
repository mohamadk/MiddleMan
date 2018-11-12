package com.mohamadk.globaladapter.test.item2

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.mohamadk.globaladapter.adapter.Binder
import com.mohamadk.globaladapter.test.R
import kotlinx.android.synthetic.main.item_layout2.view.*

class ItemView2
@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttributes: Int=0
) : CardView(context, attributes, defStyleAttributes)
    , Binder<ItemModel2> {

    init {
        inflate(context, R.layout.item_layout2, this)
        layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        useCompatPadding = true
        setCardBackgroundColor(Color.GRAY)
    }

    override fun bind(item: ItemModel2) {
        tv_title.text = item.title
        item.url//todo do something with the url ;)
    }

}