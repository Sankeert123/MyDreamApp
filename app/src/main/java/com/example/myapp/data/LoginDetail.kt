package com.example.myApp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loginTable")
data class LoginDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val emailId: String,
    val password: String,
    val mobileNumber: Long
)