package com.telekom.android.basics.di

import com.telekom.android.basics.ui.MainActivity
import com.telekom.android.logger.LogFramework
import com.telekom.android.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun injectMainActivity() : MainActivity

    companion object{
        @Provides
        fun logger(): Logger = LogFramework.getConfig().logger
    }

}