package com.app.showlistapp.presentation

import androidx.recyclerview.widget.RecyclerView
import com.app.showlistapp.databinding.ItemUsPublicDataBinding
import com.app.showlistapp.domain.entities.USPublicEntity

class ListViewHolder(private val binding: ItemUsPublicDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: USPublicEntity) {
        with(binding) {
            idYear.text = item.idYear.toString()
            nation.text = item.nation
            year.text = item.year
            population.text = item.population.toString()
        }
    }
}