package com.example.fortest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Inventory")
data class InventoryModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("Name") var name: String,
    @ColumnInfo("Amount") var amount: String,
    @ColumnInfo("InStock") var inStock: Boolean?,
    @ColumnInfo("Photo") var photo: Int?
)
