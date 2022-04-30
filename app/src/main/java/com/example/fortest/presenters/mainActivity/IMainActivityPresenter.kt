package com.example.fortest.presenters.mainActivity

import com.example.fortest.models.PhoneNumber

interface IMainActivityPresenter {

    fun fabOnClick()
    fun insert(phoneNumber: PhoneNumber)
    fun getAllContats(): List<PhoneNumber>
    fun fetch()
}