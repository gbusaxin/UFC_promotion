package com.example.ufcpromotion.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ufcpromotion.domain.pojo.ResultItem

class ResultDiffCallback : DiffUtil.ItemCallback<ResultItem>() {
    override fun areItemsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem.enemy1 == newItem.enemy1
    }

    override fun areContentsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem == newItem
    }
}