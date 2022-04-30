package com.example.fortest.views.addPhoneActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fortest.databinding.ActivityAddPhoneNumberBinding
import com.example.fortest.models.PhoneNumber
import com.example.fortest.presenters.mainActivity.MainActivityPresenter
import com.example.fortest.views.adapter.phoneAdapter

class AddPhoneNumberActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddPhoneNumberBinding
//    private val myadapter by lazy { phoneAdapter() }
//    private val presenter by lazy { MainActivityPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhoneNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        myadapter.setData(presenter.getAllContats())
//        insert()
//    }
//
//    private fun insert() {
//        binding.btnAdd.setOnClickListener {
//            val contact = PhoneNumber(
//                0,
//                binding.etName.text.toString(),
//                binding.etLastName.text.toString(),
//                "https://raw.githubusercontent.com/adizqx/calc/main/corona-unsplash.jpg"
//            )
//            presenter.insert(contact)
//
//        }
    }

}