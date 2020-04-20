package com.jonathandarwin.dagger2kotlin.di

import androidx.lifecycle.ViewModel
import com.jonathandarwin.dagger2kotlin.app.home.HomeViewModel
import com.jonathandarwin.dagger2kotlin.app.login.LoginViewModel
import com.jonathandarwin.dagger2kotlin.factory.ViewModelFactory
import com.jonathandarwin.dagger2kotlin.factory.ViewModelKey
import com.jonathandarwin.dagger2kotlin.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
class AppModule {

    @Provides
    fun provideViewModelFactory(providerMap : MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelFactory
            = ViewModelFactory(providerMap)

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideLoginViewModel(userRepository: UserRepository) : ViewModel
            = LoginViewModel(userRepository)

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideHomeViewModel(userRepository: UserRepository) : ViewModel
            = HomeViewModel(userRepository)

    @Provides
    fun provideMainRepository() : UserRepository
            = UserRepository()
}