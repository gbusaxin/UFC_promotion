package com.example.ufcpromotion.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ufcpromotion.domain.pojo.FixturesItem

class FixturesDiffCallback : DiffUtil.ItemCallback<FixturesItem>() {
    override fun areItemsTheSame(oldItem: FixturesItem, newItem: FixturesItem): Boolean {
        return oldItem.enemy1 == newItem.enemy1
    }

    override fun areContentsTheSame(oldItem: FixturesItem, newItem: FixturesItem): Boolean {
        return oldItem == newItem
    }
}