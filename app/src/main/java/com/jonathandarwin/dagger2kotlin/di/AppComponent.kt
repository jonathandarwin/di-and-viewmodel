package com.jonathandarwin.dagger2kotlin.di

import com.jonathandarwin.dagger2kotlin.app.home.HomeActivity
import com.jonathandarwin.dagger2kotlin.app.login.LoginActivity
import dagger.Component

@Component(
    modules = [AppModule::class]
)
interface AppComponent{
    fun inject(target : LoginActivity)
    fun inject(target : HomeActivity)
}