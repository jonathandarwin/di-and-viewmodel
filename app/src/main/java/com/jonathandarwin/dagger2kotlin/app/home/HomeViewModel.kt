package com.jonathandarwin.dagger2kotlin.app.home

import androidx.lifecycle.ViewModel
import com.jonathandarwin.dagger2kotlin.repository.UserRepository

class HomeViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun getLoginTime() : String {
        return userRepository.getLoginTime()
    }
}