package com.example.fortest

import android.app.Application
import androidx.room.Room
import com.example.fortest.db.room.AppDatabase

class App : Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "db")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    fun getDatabase(): AppDatabase?{
        return database
    }

    companion object {
        var instance: App? = null
    }

}