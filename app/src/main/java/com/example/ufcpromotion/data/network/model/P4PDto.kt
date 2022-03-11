package com.example.ufcpromotion.data.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class P4PDto(
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("image")
    @Expose
    val image: String? = null,
    @SerializedName("weight")
    @Expose
    val weight: String? = null
)