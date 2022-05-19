package com.example.fortest.repositories

import androidx.room.*
import com.example.fortest.models.InventoryModel

@Dao
interface InventoryDao {
    @Query("SELECT * FROM Inventory")
    fun getAllInventory(): List<InventoryModel>

    @Query("SELECT * FROM Inventory WHERE id = :id")
    fun getInventoryById(id:Int): List<InventoryModel>


    @Insert
    fun insertInventory(vararg inventoryModel: InventoryModel)

    @Delete
    fun deleteInventory(inventoryModel: InventoryModel)

    @Update
    fun updateInventory(inventoryModel: InventoryModel)
}