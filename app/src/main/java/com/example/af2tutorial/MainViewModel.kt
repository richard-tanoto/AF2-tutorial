package com.example.af2tutorial

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.af2tutorial.data.User
import com.example.af2tutorial.data.UserRepository

class MainViewModel(application: Application): ViewModel() {

    private val userRepository = UserRepository(application)

    fun insertUser(user: User) {
        userRepository.insert(user)
    }

    fun deleteUser(user: User) {
        userRepository.delete(user)
    }

    fun findUser(name: String): User? = userRepository.find(name)

}