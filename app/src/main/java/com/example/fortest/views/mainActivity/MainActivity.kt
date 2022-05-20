package com.example.fortest.views.mainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fortest.databinding.ActivityMainBinding
import com.example.fortest.db.models.Inventory
import com.example.fortest.presenters.mainActivity.MainPresenter
import com.example.fortest.views.adapter.ItemAdapter
import com.example.fortest.views.addActivity.AddActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Files.delete

class MainActivity : AppCompatActivity(), IMainView{
    private var binding: ActivityMainBinding? = null
    private val presenter by lazy { MainPresenter(this) }
    private val adapter by lazy { ItemAdapter() }
    private var list: MutableList<Inventory>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        clicksListeners()
        getAllItems()
        delete()

    }

    private fun clicksListeners() {
        binding?.fabtn?.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    private fun getAllItems() = CoroutineScope(Dispatchers.IO).launch {
        list?.clear()
        list = presenter.getAllItems()?.toMutableList()
        adapter.differ.submitList(list)
        binding?.rcView?.adapter = adapter
        binding?.rcView?.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter.notifyDataSetChanged()
    }

    private fun delete() {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val item = adapter.differ.currentList[position]
                list?.remove(item)
                CoroutineScope(Dispatchers.IO).launch {
                    presenter.delete(item)
                }
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding?.rcView)
        }
    }

    override fun showTextDeleted() {
        Toast.makeText(this, "Successfully deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}