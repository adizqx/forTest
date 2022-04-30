package com.example.fortest.repositories

import com.example.fortest.App
import com.example.fortest.models.PhoneNumber

class Repository {
    private val db = App.instance
    private val dao = db?.getDb()?.PhoneNumberDao()

    init {
        getAllContacts()
    }

    fun insert(phoneNumbers: PhoneNumber) {
        dao?.insertPhoneNumber(phoneNumbers)
    }

    fun getAllContacts(): List<PhoneNumber> {
        return dao!!.getAllPhoneNumber()
    }
}