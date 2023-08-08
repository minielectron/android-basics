package com.telekom.android.basics.di

import com.telekom.android.basics.model.DemoClass
import com.telekom.android.basics.model.Person
import com.telekom.android.basics.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun injectMainActivity() : MainActivity

    companion object{
        @Provides
        fun providesDemoClass(person: Person) = DemoClass(person)

        @Provides
        fun person() = Person("John", 54)
    }

}