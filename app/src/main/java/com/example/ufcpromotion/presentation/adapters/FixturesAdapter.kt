package com.example.ufcpromotion.presentation.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ufcpromotion.R
import com.example.ufcpromotion.databinding.ItemFixturesBinding
import com.example.ufcpromotion.domain.pojo.FixturesItem
import javax.inject.Inject

class FixturesAdapter @Inject constructor(
    private val application: Application
) : ListAdapter<FixturesItem, FixturesAdapter.FixturesViewHolder>(FixturesDiffCallback()) {

    inner class FixturesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFixturesBinding.bind(view)
        val enemy1 = binding.textViewFixturesEnemy1
        val enemy2 = binding.textViewFixturesEnemy2
        val image1 = binding.imageViewFixturesEnemy1
        val image2 = binding.imageViewFixturesEnemy2
        val weight = binding.textViewFixturesWeight
        val number = binding.textViewFixturesNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        return FixturesViewHolder(
            LayoutInflater.from(application).inflate(R.layout.item_fixtures, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        val item = getItem(position)
        with(holder ){
            enemy1.text = item.enemy1
            enemy2.text = item.enemy2
            weight.text = item.weight
            number.text = item.number
            image1.load(item.enemy1image)
            image2.load(item.enemy2image)
        }
    }
}