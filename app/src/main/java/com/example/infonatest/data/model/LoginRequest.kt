package com.example.infonatest.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("credentials")
    val credential: String
)
