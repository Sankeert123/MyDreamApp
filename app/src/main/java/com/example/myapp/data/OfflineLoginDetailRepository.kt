package com.example.myApp.data

import kotlinx.coroutines.flow.Flow

class OfflineLoginDetailRepository(private val loginDao: LoginDao): MyAppRepository {
    override fun getAllLoginDetails(): Flow<List<LoginDetail>> {
        TODO("Not yet implemented")
    }

    override fun getLoginDetail(id: Int): Flow<LoginDetail> {
        TODO("Not yet implemented")
    }

    override suspend fun insertLoginDetail(loginDetail: LoginDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLoginDetail(loginDetail: LoginDetail) {
        TODO("Not yet implemented")
    }

    override suspend fun updateLoginDetail(loginDetail: LoginDetail) {
        TODO("Not yet implemented")
    }


}