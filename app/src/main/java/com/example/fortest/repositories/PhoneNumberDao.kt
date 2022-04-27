package com.example.fortest.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fortest.models.PhoneNumber

interface PhoneNumberDao {

    @Query("SELECT * FROM Phones")
    fun getAllPhoneNumber(): List<PhoneNumber>

    @Query("SELECT * FROM Phones WHERE id = :id")
    fun getPhoneNumberById(id:Int): List<PhoneNumber>


    @Insert
    fun insertPhoneNumber(vararg phoneNumber: PhoneNumber)

    @Delete
    fun deletePhoneNumber(phoneNumber: PhoneNumber)

    @Update
    fun updatePhoneNumber(phoneNumber: PhoneNumber)
}