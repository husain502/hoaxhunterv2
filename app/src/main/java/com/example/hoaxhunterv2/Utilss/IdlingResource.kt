package com.example.hoaxhunterv2.Utilss

import androidx.test.espresso.idling.CountingIdlingResource

object IdlingResource {

    private const val RESOURCE = "GLOBAL"

    val idlingResource = CountingIdlingResource(RESOURCE)

    fun decrement(){
        idlingResource.decrement()
    }

    fun increment(){
        idlingResource.increment()
    }
}