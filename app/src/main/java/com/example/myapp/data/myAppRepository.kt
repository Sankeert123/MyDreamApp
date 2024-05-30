package com.example.myApp.data

import kotlinx.coroutines.flow.Flow

interface MyAppRepository {


    // Retrieve all items from the Database
    fun getAllLoginDetails(): Flow<List<LoginDetail>>

    // Retrieving single item with id
    fun getLoginDetail(id: Int): Flow<LoginDetail>

    // Inserting a LoginDetail
    suspend fun insertLoginDetail(loginDetail: LoginDetail)

    // Deleting a LoginDetail
    suspend fun deleteLoginDetail(loginDetail: LoginDetail)

    // Updating a LoginDetail
    suspend fun updateLoginDetail(loginDetail: LoginDetail)

}