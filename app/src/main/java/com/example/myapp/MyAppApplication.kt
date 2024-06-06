package com.example.myApp

import android.app.Application
import com.example.myApp.data.AppContainer
import com.example.myApp.data.DefaultAppContainer
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton

@HiltAndroidApp
class MyAppApplication: Application() {


    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        @Singleton
        @Provides
        container = DefaultAppContainer(context = this)
    }

}