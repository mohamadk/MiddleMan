package com.mohamadk.middleman.intractors

interface RequireInteractor<in INTERACTOR> {
    fun setInteractor(intractor: INTERACTOR)
}