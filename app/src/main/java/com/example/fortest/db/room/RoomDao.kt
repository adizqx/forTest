package com.example.fortest.db.room

import androidx.room.*
import com.example.fortest.db.models.Inventory

@Dao
interface RoomDao {
    @Insert
    suspend fun insert(inventory: Inventory)

    @Update
    suspend fun update(inventory: Inventory)

    @Delete
    suspend fun delete(inventory: Inventory)

    @Query("SELECT * FROM inventory")
    suspend fun getAll(): List<Inventory>
}