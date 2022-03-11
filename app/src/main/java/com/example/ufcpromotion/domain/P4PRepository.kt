package com.example.ufcpromotion.domain

import androidx.lifecycle.LiveData
import com.example.ufcpromotion.domain.pojo.P4PItem

interface P4PRepository {
    fun getP4PData(): LiveData<List<P4PItem>>
    fun loadP4PData()
}