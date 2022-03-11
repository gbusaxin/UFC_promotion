package com.example.ufcpromotion.presentation.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ufcpromotion.R
import com.example.ufcpromotion.databinding.ItemNewsBinding
import com.example.ufcpromotion.domain.pojo.NewsItem
import javax.inject.Inject

class NewsAdapter @Inject constructor(
    private val application: Application
) : ListAdapter<NewsItem, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {
    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemNewsBinding.bind(view)
        val title = binding.textViewNewsTitle
        val short = binding.textViewNewsShort
        val date = binding.textViewNewsDate
        val image = binding.imageViewNews
    }

    var onNewsClick: ((NewsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(application).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            title.text = item.titleNews
            short.text = item.shortNews
            date.text = item.dateNews
            image.load(item.imageNews)
            itemView.setOnClickListener {
                onNewsClick?.invoke(item)
            }
        }
    }
}