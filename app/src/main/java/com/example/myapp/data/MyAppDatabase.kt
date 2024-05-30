package com.example.myApp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [LoginDetail::class], version = 1, exportSchema = false)
abstract class MyAppDatabase: RoomDatabase(){

    abstract fun loginDao(): LoginDao

    companion object {

        @Volatile
        private var db: MyAppDatabase? = null

        fun getDatabase(context: Context): MyAppDatabase {

            return db ?: synchronized(this) {
                Room.databaseBuilder(context, MyAppDatabase::class.java, "myAppDatabase")
                    .build().also {
                        db = it
                    }
            }

        }

    }


}