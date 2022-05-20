package com.example.fortest.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fortest.db.models.Inventory


@Database(entities = [Inventory::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): RoomDao
}