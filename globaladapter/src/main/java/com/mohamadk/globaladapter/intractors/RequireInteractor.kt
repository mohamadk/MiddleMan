package com.mohamadk.globaladapter.intractors

interface RequireInteractor<in INTERACTOR> {
    fun setInteractor(intractor: INTERACTOR)
}