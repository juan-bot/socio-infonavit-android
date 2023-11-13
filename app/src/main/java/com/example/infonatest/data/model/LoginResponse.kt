package com.example.infonatest.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    var succes: Boolean,
    @SerializedName("data")
    var data: String,
    @SerializedName("jtw")
    var jtw: String,

)
