package com.mohamadk.middleman.test

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamadk.middleman.adapter.adapters.GeneralViewAdapter
import com.mohamadk.middleman.adapter.model.BaseModel
import com.mohamadk.middleman.adapter.networkstate.NetworkState
import com.mohamadk.middleman.intractors.RetryListener
import com.mohamadk.middleman.test.item1.ItemModel
import com.mohamadk.middleman.test.item2.ItemModel2
import kotlinx.android.synthetic.main.list_fragment.*

class SampleListFragment
    : BaseListFragment()
    , SampleIntractor
    , RetryListener
{

    private val defaultItems = listOf<BaseModel>(
        ItemModel("1", "Name1", "Family1")
        , ItemModel("2", "Name2", "Family2")
        , ItemModel("3", "Name3", "Family3")
        , ItemModel("4", "Name4", "Family4")

        , ItemModel2("1", "title1", "url1")

        , ItemModel("6", "Name6", "Family6")
        , ItemModel("7", "Name7", "Family7")
        , ItemModel("8", "Name8", "Family8")

        , ItemModel2("2", "title2", "url2")

        , ItemModel("10", "Name10", "Family10")
        , ItemModel("11", "Name11", "Family11")
        , ItemModel("12", "Name12", "Family12")
        , ItemModel("13", "Name13", "Family13")
        , ItemModel("14", "Name14", "Family14")
        , ItemModel("15", "Name15", "Family15")
        , ItemModel("16", "Name16", "Family16")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.apply {

            adapter = GeneralViewAdapter(this@SampleListFragment).also {

                it.setNetworkState(NetworkState.LOADING)

                Handler().postDelayed({

                    it.setNetworkState(NetworkState.LOADED)
                    it.submitList(defaultItems)

                },1000)

            }
            layoutManager = LinearLayoutManager(activity)
        }
    }

    //sample call from items in adapter to fragment to interact. of course you can implement
    // as many as you want in here and use them in your items
    override fun doSomething() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     * called when user click retry button in networkStateView
     */
    override fun retry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}