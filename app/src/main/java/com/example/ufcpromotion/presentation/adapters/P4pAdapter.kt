package com.example.ufcpromotion.presentation.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ufcpromotion.R
import com.example.ufcpromotion.databinding.ItemP4pBinding
import com.example.ufcpromotion.domain.pojo.P4PItem
import javax.inject.Inject

class P4pAdapter @Inject constructor(
    private val application: Application
) : ListAdapter<P4PItem, P4pAdapter.P4pViewHolder>(P4pDiffCallback()) {

    inner class P4pViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemP4pBinding.bind(view)
        val image = binding.imageViewP4PImage
        val name = binding.textViewP4PName
        val weight = binding.textViewP4PWeight
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): P4pViewHolder {
        return P4pViewHolder(
            LayoutInflater.from(application).inflate(
                R.layout.item_p4p,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: P4pViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            name.text = item.name
            weight.text = item.weight
            image.load(item.image)
        }
    }
}