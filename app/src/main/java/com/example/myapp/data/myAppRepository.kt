package com.example.myApp.data

import kotlinx.coroutines.flow.Flow

interface MyAppRepository {


    // Retrieve all items from the Database
    fun getAllLoginDetailsStream(): Flow<List<LoginDetail>>

    // Retrieving single item with id
    fun getLoginDetailStream(id: Int): Flow<LoginDetail>

    // Inserting a LoginDetail
    suspend fun insertLoginDetailStream(loginDetail: LoginDetail)

    // Deleting a LoginDetail
    suspend fun deleteLoginDetailStream(loginDetail: LoginDetail)

    // Updating a LoginDetail
    suspend fun updateLoginDetailStream(loginDetail: LoginDetail)

}