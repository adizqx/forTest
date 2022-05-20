package com.example.fortest.db.models

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val quantity: Int,
    val categoryName: String,
    val photo: String
)
