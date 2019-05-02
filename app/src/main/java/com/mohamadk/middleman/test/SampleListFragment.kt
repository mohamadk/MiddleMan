package com.mohamadk.middleman.test

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamadk.middleman.adapter.GeneralViewAdapter
import com.mohamadk.middleman.intractors.RetryListener
import kotlinx.android.synthetic.main.list_fragment.*

class SampleListFragment
    : BaseListFragment()
    , SampleIntractor
    , RetryListener
{

    val repository=FakeRepository()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.apply {

            adapter = GeneralViewAdapter(this@SampleListFragment).also { adapter->

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

        repository.start()

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