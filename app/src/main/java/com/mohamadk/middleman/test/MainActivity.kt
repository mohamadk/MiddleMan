package com.mohamadk.middleman.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContent, SampleListFragment(),SampleListFragment::class.simpleName)
            .commit()
    }
}
