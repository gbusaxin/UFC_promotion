package com.example.ufcpromotion.presentation.adapters

import android.app.Application
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ufcpromotion.R
import com.example.ufcpromotion.databinding.ItemResultBinding
import com.example.ufcpromotion.domain.pojo.ResultItem
import javax.inject.Inject

class ResultAdapter @Inject constructor(
    private val application: Application
) : ListAdapter<ResultItem, ResultAdapter.ResultViewHolder>(ResultDiffCallback()) {

    inner class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultBinding.bind(view)
        val enemy1 = binding.textViewResultEnemy1
        val enemy2 = binding.textViewResultEnemy2
        val image1 = binding.imageViewResultEnemy1
        val image2 = binding.imageViewResultEnemy2
        val number = binding.textViewResultNumber
        val weight = binding.textViewResultWeight
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(application).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            when (item.whoWin) {
                1 -> {
                    enemy1.text = item.enemy1
                    enemy1.setTextColor(Color.GREEN)
                    enemy2.text = item.enemy2
                    enemy2.setTextColor(Color.RED)
                }
                2 -> {
                    enemy1.text = item.enemy1
                    enemy1.setTextColor(Color.RED)
                    enemy2.text = item.enemy2
                    enemy2.setTextColor(Color.GREEN)
                }
                else -> {
                    enemy1.text = item.enemy1
                    enemy1.setTextColor(Color.YELLOW)
                    enemy2.text = item.enemy2
                    enemy2.setTextColor(Color.YELLOW)
                }
            }
            number.text = item.number
            weight.text = item.weight
            image1.load(item.enemy1image)
            image2.load(item.enemy2image)
        }
    }
}