package com.example.infonatest.doman.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.infonatest.data.model.LoginRequest
import com.example.infonatest.data.model.LoginResponse
import com.example.infonatest.data.network.RetrofitInfonavit
import com.google.gson.JsonObject
import retrofit2.Response

class LoginRepository {
     suspend fun authenticationApi(context: Context) {
         var request = LoginRequest(
             credential = "sdfdfgdfg"
         )
         if(isConnected(context)){
             val res = RetrofitInfonavit.api().loginUser(request)
             if (res.isSuccessful) {
                 Log.i("API","yess")
                 res.body() // do something with this
             } else {
                 res.errorBody() // do something with that
                 Log.i("API","${res.errorBody()}")
             }
         }
         else
             Log.i("Internet", "NO CONEXION")
     }
    private fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

}