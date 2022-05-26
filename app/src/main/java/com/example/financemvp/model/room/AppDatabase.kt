package com.example.financemvp.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.financemvp.model.models.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): RoomDao
}