package com.telekom.android.basics.di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class LearnApplication: DaggerApplication() {

    private val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }
}