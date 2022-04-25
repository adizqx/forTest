package com.example.fortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.fortest.databinding.ActivityMainBinding
import com.example.fortest.models.User
import com.example.fortest.presenters.IMainActivityPresenter
import com.example.fortest.presenters.MainActivityPresenter

class MainActivity : AppCompatActivity(),MainActivityView {

    lateinit var binding: ActivityMainBinding

    lateinit var presenter:IMainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = User(null,null)
        presenter = MainActivityPresenter(this, user)
        binding.btn.setOnClickListener {
            presenter.onBtnClick()
        }
        binding.tv1.addTextChangedListener {
            presenter.NameOnChangeListener()
        }
        binding.tv2.addTextChangedListener {
            presenter.lastNameOnChangeListener()
        }
    }

    override fun getNameEditText(): String {
        return binding.et1.text.toString()
    }

    override fun getLastNameEditText(): String {
        return binding.et2.text.toString()
    }

    override fun setName(text: String) {
        binding.tv1.text = text
    }

    override fun setLastName(text: String) {
        binding.tv2.text = text
    }
}