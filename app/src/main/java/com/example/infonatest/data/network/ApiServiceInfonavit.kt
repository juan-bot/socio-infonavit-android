package com.example.infonatest.data.network

import com.example.infonatest.data.model.BenevitRequest
import com.example.infonatest.data.model.LoginRequest
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceInfonavit {
    @POST("/api/v2/member/authentication")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<JsonObject>

    @POST("/api/v1/member/member_benevits/search")
    suspend fun getBenevits(@Body getBenev: BenevitRequest): Response<JsonObject>
}