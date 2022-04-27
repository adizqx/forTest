package com.example.fortest.repositories

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fortest.models.PhoneNumber

@Database(entities = [PhoneNumber::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PhoneNumberDao(): PhoneNumberDao
}