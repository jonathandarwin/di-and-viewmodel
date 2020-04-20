package com.jonathandarwin.dagger2kotlin.repository

import com.jonathandarwin.dagger2kotlin.model.User
import java.text.SimpleDateFormat
import java.util.*

class UserRepository {
    fun doLogin(user : User) : Boolean {
        return !user.username.equals("") && !user.password.equals("")
    }

    fun getLoginTime() : String {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd MMMM yyyy HH:mm:ss")
        return formatter.format(calendar.time)
    }
}