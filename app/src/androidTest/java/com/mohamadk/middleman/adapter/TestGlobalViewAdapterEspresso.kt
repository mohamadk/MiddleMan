package com.mohamadk.middleman.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mohamadk.middleman.test.MainActivity
import com.mohamadk.middleman.test.SampleListFragment
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class TestGlobalViewAdapterEspresso {


    private var activity: MainActivity? = null
    private var recyclerView: RecyclerView? = null


    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun init() {
    }

    @Test
    fun testLaunchFragment() {

        val fragment =
            activityTestRule.activity.supportFragmentManager.findFragmentByTag(SampleListFragment::class.simpleName)

        assertNotNull(fragment)
    }


}