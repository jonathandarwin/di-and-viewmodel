package com.jonathandarwin.dagger2kotlin.app.login

import androidx.lifecycle.ViewModel
import com.jonathandarwin.dagger2kotlin.model.User
import com.jonathandarwin.dagger2kotlin.repository.UserRepository

class LoginViewModel(private val userRepository: UserRepository) : ViewModel(){

    val user : User by lazy {
        User("", "")
    }

    fun doLogin() : Boolean {
        return userRepository.doLogin(user)
    }
}