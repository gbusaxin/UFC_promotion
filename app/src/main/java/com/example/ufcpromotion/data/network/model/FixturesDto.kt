package com.example.ufcpromotion.data.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class FixturesDto(
    @SerializedName("enemy1")
    @Expose
    val enemy1: String? = null,
    @SerializedName("enemy1image")
    @Expose
    val enemy1image: String? = null,
    @SerializedName("enemy2")
    @Expose
    val enemy2: String? = null,
    @SerializedName("enemy2image")
    @Expose
    val enemy2image: String? = null,
    @SerializedName("whoWin")
    @Expose
    val whoWin: Int? = null,
    @SerializedName("number")
    @Expose
    val number: String? = null,
    @SerializedName("weight")
    @Expose
    val weight: String? = null
)
