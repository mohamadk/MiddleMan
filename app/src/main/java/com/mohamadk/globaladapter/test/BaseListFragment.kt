package com.mohamadk.globaladapter.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


open class BaseListFragment: androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment,container,false)
    }



}