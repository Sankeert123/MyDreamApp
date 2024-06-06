package com.example.myApp.data

import kotlinx.coroutines.flow.Flow

class OfflineLoginDetailRepository(private val loginDao: LoginDao): MyAppRepository {
    override fun getAllLoginDetailsStream(): Flow<List<LoginDetail>> {
        return  loginDao.getAllLoginDetail()
    }

    override fun getLoginDetailStream(id: Int): Flow<LoginDetail> {
        return loginDao.getLoginDetail(id = id)
    }

    override suspend fun insertLoginDetailStream(loginDetail: LoginDetail) {
       return loginDao.insertingToLoginDetail(loginDetail = loginDetail)
    }

    override suspend fun deleteLoginDetailStream(loginDetail: LoginDetail) {
       return loginDao.deleteLoginDetail(loginDetail = loginDetail)
    }

    override suspend fun updateLoginDetailStream(loginDetail: LoginDetail) {
        return loginDao.updatingLoginDetail(loginDetail = loginDetail)
    }


}