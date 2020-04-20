package com.jonathandarwin.dagger2kotlin

import android.app.Application
import com.jonathandarwin.dagger2kotlin.di.AppComponent
import com.jonathandarwin.dagger2kotlin.di.DaggerAppComponent

class App : Application() {

    private lateinit var applicationComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent.builder().build()
    }

    public fun getAppComponent() : AppComponent {
        return applicationComponent
    }
}