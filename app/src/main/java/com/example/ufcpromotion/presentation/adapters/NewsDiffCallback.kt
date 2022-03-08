package com.example.ufcpromotion.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ufcpromotion.domain.pojo.NewsItem

class NewsDiffCallback : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.titleNews == newItem.titleNews
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}