package com.firatgunay.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firatgunay.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddItem.setOnClickListener {
            val newItem = binding.etNewItem.text.toString()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem)
                binding.etNewItem.text.clear()
                updateItemList()
            } else {
                Toast.makeText(this, "Please enter an item", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateItemList() {
        var itemListText = "Items:\n"
        for (item in itemList) {
            itemListText += "- $item\n"
        }
        binding.tvItems.text = itemListText
    }
}