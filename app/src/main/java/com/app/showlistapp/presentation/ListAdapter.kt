package com.app.showlistapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.showlistapp.databinding.ItemUsPublicDataBinding
import com.app.showlistapp.domain.entities.USPublicEntity

class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var listItems: List<USPublicEntity> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItems: List<USPublicEntity>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUsPublicDataBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}