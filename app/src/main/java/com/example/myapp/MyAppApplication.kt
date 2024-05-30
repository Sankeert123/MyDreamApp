package com.example.myApp

import android.app.Application
import com.example.myApp.data.AppContainer
import com.example.myApp.data.DefaultAppContainer

class MyAppApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}