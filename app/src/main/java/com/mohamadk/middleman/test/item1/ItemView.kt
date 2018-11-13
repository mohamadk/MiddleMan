package com.mohamadk.middleman.test.item1

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.mohamadk.middleman.adapter.Binder
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemView
@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttributes: Int = 0
) : CardView(context, attributes, defStyleAttributes)
    , Binder<ItemModel>
    {

    override fun bind(item: ItemModel?) {
        tv_name.text = item!!.name
        tv_family.text = item.family
    }

}