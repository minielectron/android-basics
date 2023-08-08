package com.telekom.android.basics.ui

import android.os.Bundle
import com.telekom.android.basics.R
import com.telekom.android.basics.model.DemoClass
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var demoClass: DemoClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        demoClass.showName()
    }
}