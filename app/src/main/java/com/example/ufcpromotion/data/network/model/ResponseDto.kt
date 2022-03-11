package com.example.ufcpromotion.data.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
class ResponseDto(
    @SerializedName("url")
    @Expose
    var response: String
)