package com.ldj.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ldj.databinding.databinding.ListItemBinding

class MyListAdapter: ListAdapter<ListItem, MyListAdapter.ListItemHolder>(Companion) {

    class ListItemHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater)
        return ListItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        holder.binding.listItem = getItem(position)
        holder.binding.executePendingBindings()
    }
}