package com.mohamadk.middleman.networkstate

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


class TestNetworkState {

    @Test
    fun testCompare_areContentsTheSame() {


        val loaded: NetworkState = NetworkState.LOADED
        val loading: NetworkState = NetworkState.LOADING
        val errorMessage = "error message"
        val error: NetworkState = NetworkState.error(errorMessage)

        loaded mustBe NetworkState.LOADED
        loaded mustNotBe error
        loaded mustNotBe loading

        loading mustBe NetworkState.LOADING
        loading mustNotBe error
        loading mustNotBe loaded

        error mustBe NetworkState.error(errorMessage)
        error mustNotBe loading
        error mustNotBe loaded
    }


}

private infix fun Any.mustBe(arg: Any) {
    assertEquals(this, arg, " $this must be equal with $arg but it is not")
}

private infix fun Any.mustNotBe(arg: Any) {
    assertNotEquals(this, arg, " $this must be equal with $arg but it is not")
}
