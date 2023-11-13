package com.example.infonatest.presentation.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infonatest.doman.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private var repo = LoginRepository()
    fun apiCallLogin(context: Context){
        viewModelScope.launch {
            val res = repo.authenticationApi(context)

        }
    }
}