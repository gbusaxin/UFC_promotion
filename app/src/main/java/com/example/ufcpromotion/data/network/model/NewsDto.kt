package com.example.ufcpromotion.data.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Keep
data class NewsDto(
    @SerializedName("imageNews")
    @Expose
    val imageNews: String? = null,
    @SerializedName("titleNews")
    @Expose
    val titleNews: String? = null,
    @SerializedName("shortNews")
    @Expose
    val shortNews: String? = null,
    @SerializedName("dateNews")
    @Expose
    val dateNews: String? = null,
    @SerializedName("bodyNews")
    @Expose
    val bodyNews: String? = null
)