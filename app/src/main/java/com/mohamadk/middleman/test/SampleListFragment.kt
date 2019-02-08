package com.mohamadk.middleman.test

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
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

    lateinit var repository:Repository


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.apply {

            adapter = GeneralViewAdapter(this@SampleListFragment).also {adapter->

                val listing=repository.getList()

                listing.networkStateLive.observe(this@SampleListFragment, Observer{
                    adapter.setNetworkState(it)
                })

                listing.listLive.observe(this@SampleListFragment, Observer {
                    adapter.submitList(it)
                })

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