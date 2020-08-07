package com.ldj.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyListViewModel : ViewModel() {
    private var itemCount = 0

    val data = MutableLiveData<List<ListItem>>().apply { value = emptyList() }

    fun addButtonClicked() {
        data.value = data.value!!.toMutableList().apply {
            val itemNumber = itemCount++
            add(ListItem(itemNumber, "Item $itemNumber", 0))
        }
    }

    fun removeButtonClicked() {
        data.value = data.value!!.toMutableList().apply {
            if (isNotEmpty()) removeAt(size - 1)
        }
    }

    fun updateButtonClicked() {
        data.value = data.value!!.map { item -> item.copy(count = item.count + 1) }
    }
}