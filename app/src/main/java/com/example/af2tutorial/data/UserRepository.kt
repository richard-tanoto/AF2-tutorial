package com.example.af2tutorial.data

import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepository(application: Application) {

    private val userDao: UserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = UserDatabase.getDatabase(application)
        userDao = db.userDao()
    }

    fun insert(user: User) {
        executorService.execute { userDao.insertUser(user) }
    }

    fun delete(user: User) {
        executorService.execute { userDao.deleteUser(user) }
    }

    fun find(name: String): User? = userDao.findUser(name)

}