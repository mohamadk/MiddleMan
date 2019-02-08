package com.mohamadk.middleman.test

import androidx.lifecycle.LiveData
import com.mohamadk.middleman.adapter.model.BaseModel
import com.mohamadk.middleman.adapter.networkstate.NetworkState

class Listing (
    val listLive:LiveData<List<BaseModel>>,
    val networkStateLive:LiveData<NetworkState>
){




}
