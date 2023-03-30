package com.example.af2tutorial.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @ColumnInfo("lastName")
    val lastName: String,

    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("avatar")
    val avatar: String,

    @ColumnInfo("first_name")
    val firstName: String,

    @ColumnInfo("email")
    val email: String,

    @ColumnInfo("isFavorite")
    var isFavorite: Boolean
)