package com.example.af2tutorial.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE first_name = :name LIMIT 1")
    fun findUser(name: String): User?
}