package com.mohamadk.middleman

import org.junit.Assert

infix fun Any?.mustBe(arg:Any?){
    Assert.assertEquals(this,arg)
}
infix fun Any?.mustNotBe(arg:Any?){
    Assert.assertNotEquals(this,arg)
}