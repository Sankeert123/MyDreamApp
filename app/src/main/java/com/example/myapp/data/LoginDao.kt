package com.example.myApp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertingToLoginDetail(loginDetail: LoginDetail)

    @Update
    suspend fun updatingLoginDetail(loginDetail: LoginDetail)

    @Delete
    suspend fun deleteLoginDetail(loginDetail: LoginDetail)

    @Query("SELECT * FROM loginTable ORDER BY userName ASC")
    fun getAllLoginDetail(): Flow<List<LoginDetail>>

    @Query("SELECT * FROM loginTable WHERE id = :id")
    fun getLoginDetail(id: Int): Flow<LoginDetail>
}