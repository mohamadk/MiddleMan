package com.mohamadk.middleman.test

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.mohamadk.middleman.model.BaseModel
import com.mohamadk.middleman.networkstate.NetworkState
import com.mohamadk.middleman.test.item1.ItemModel
import com.mohamadk.middleman.test.item2.ItemModel2

class FakeRepository : Repository {

    private val networkStateLive = MutableLiveData<NetworkState>()
    private val listLive = MutableLiveData<List<BaseModel>>()


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


    override fun getList(): Listing {
        return Listing(listLive, networkStateLive)
    }

    fun start() {
        networkStateLive.postValue(NetworkState.LOADING)

        Handler().postDelayed({
            networkStateLive.postValue(NetworkState.LOADED)

            listLive.postValue(defaultItems)

        }, 2000)


    }

}
