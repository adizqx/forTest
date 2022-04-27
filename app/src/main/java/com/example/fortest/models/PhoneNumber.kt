package com.example.fortest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Phones")
data class PhoneNumber(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("Name") var name: String,
    @ColumnInfo("PhoneNumber") var phoneNumber: String,
    @ColumnInfo("Photo") var photo: String?
)
