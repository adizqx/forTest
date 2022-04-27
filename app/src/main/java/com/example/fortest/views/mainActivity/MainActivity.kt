package com.example.fortest.views.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fortest.databinding.ActivityMainBinding
import com.example.fortest.presenters.mainActivity.IMainActivityPresenter

class MainActivity : AppCompatActivity(), IMainActivityView {

    lateinit var binding: ActivityMainBinding

    lateinit var presenter: IMainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun setRecyclerView() {

    }

    override fun addContactButton() {

    }

    override fun adapterItemOnClick() {

    }


}