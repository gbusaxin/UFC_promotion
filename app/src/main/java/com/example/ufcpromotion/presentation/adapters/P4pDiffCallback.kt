package com.example.ufcpromotion.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ufcpromotion.domain.pojo.P4PItem

class P4pDiffCallback : DiffUtil.ItemCallback<P4PItem>() {
    override fun areItemsTheSame(oldItem: P4PItem, newItem: P4PItem): Boolean {
        return oldItem.name == newItem.weight
    }

    override fun areContentsTheSame(oldItem: P4PItem, newItem: P4PItem): Boolean {
        return oldItem == newItem
    }
}