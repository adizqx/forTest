package com.example.fortest

interface MainActivityView {
    fun getNameEditText(): String
    fun getLastNameEditText(): String
    fun setName(text: String)
    fun setLastName(text: String)

}