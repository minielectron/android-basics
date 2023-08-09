package com.telekom.android.basics.ui

import android.os.Bundle
import com.telekom.android.basics.R
import com.telekom.android.logger.Logger
import com.telekom.android.logger.log
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {


    @Inject
    lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.log(message = { "Testing logger" })
    }
}