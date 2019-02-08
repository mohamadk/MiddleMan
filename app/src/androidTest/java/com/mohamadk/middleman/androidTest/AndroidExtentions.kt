package com.mohamadk.middleman.androidTest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.CoreMatchers
import org.junit.Assert

infix fun Any?.mustBe(arg: Any?) {
    Assert.assertEquals(this, arg)
}

infix fun Any?.mustNotBe(arg: Any?) {
    Assert.assertNotEquals(this, arg)
}


class RecyclerViewItemCountAssertion(
    private val expectedCount: Int,
    val check: ((view: View) -> Unit)? = null
) : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter

        check?.invoke(recyclerView.layoutManager!!.findViewByPosition(0)!!)

        Assert.assertThat(adapter!!.itemCount, CoreMatchers.`is`(expectedCount))
    }
}