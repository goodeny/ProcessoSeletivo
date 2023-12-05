package com.example.processoseletivo

import android.app.*
import androidx.room.*

class MyApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "app-database").build()
    }
}