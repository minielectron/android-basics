package com.telekom.android.basics.di

import com.telekom.android.logger.FileLogger
import com.telekom.android.logger.LogFramework
import com.telekom.android.logger.LogLevel
import com.telekom.android.logger.LoggerConfig
import com.telekom.android.logger.TimberLogger
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class LearnApplication: DaggerApplication() {

    private val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

    override fun onCreate() {
        super.onCreate()
        val logger = FileLogger(applicationContext)
        val loggerConfig = LoggerConfig(logger, true, defaultLogLevel = LogLevel.ERROR)
        LogFramework.init(loggerConfig)
    }
}