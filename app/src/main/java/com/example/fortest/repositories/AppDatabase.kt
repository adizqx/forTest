package com.example.fortest.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fortest.models.InventoryModel


@Database(entities = [InventoryModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

//    companion object{
//        val DATABASE_NAME = "phonenumberTable"
//        var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase{
//            if(instance == null){
//                instance = Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME)
//                    .allowMainThreadQueries().build()
//            }
//            return instance as AppDatabase
//        }
//    }
    abstract fun InventoryDao(): InventoryDao
}