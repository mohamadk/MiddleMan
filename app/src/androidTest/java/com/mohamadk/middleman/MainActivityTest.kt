package com.mohamadk.middleman

import com.mohamadk.middleman.test.BuildConfig
import com.mohamadk.middleman.test.MainActivity
import com.mohamadk.middleman.test.SampleListFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
//@Config(constants = BuildConfig::class)
class MainActivityTest{

    @Test
    fun testLaunchListFragment() {

        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)

        val listFragment = mainActivity.supportFragmentManager.findFragmentByTag(SampleListFragment::class.simpleName)

        listFragment mustNotBe null
    }
}