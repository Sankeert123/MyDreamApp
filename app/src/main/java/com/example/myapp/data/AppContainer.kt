package com.example.myApp.data

import android.content.Context

interface AppContainer {

    val myAppRepository: MyAppRepository
}

class DefaultAppContainer(context: Context): AppContainer {

    override val myAppRepository: MyAppRepository by lazy {
        OfflineLoginDetailRepository(MyAppDatabase.getDatabase(context).loginDao())
    }



}