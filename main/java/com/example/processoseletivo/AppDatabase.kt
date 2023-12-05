package com.example.processoseletivo

import androidx.room.*

@Database(entities = [BDcandidato::class, BDempresa::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao() : DatabaseDao
}
