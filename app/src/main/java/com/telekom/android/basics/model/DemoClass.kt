package com.telekom.android.basics.model

import android.util.Log

// Remove this class once you learn how to inject
class DemoClass(private val person: Person) {
    fun showName(){
        Log.d("","DemoClass:showName ${person.name}")
    }
}

data class Person(val name: String, val age: Int)