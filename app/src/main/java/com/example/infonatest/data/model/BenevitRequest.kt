package com.example.infonatest.data.model

import com.google.gson.annotations.SerializedName

data class BenevitRequest(
    @SerializedName("query")
    val input: String
)
