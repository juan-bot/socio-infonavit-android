package com.example.infonatest.presentation.view.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.example.infonatest.R
import com.example.infonatest.databinding.ActivityLoginBinding
import com.example.infonatest.presentation.vm.LoginViewModel

class LoginAct : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.etUser.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.btnLogin.isEnabled = valida()
            }
        })
        binding.etPassword.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.btnLogin.isEnabled = valida()

            }
        })
        binding.btnLogin.setOnClickListener {
           viewModel.apiCallLogin(applicationContext)
            val intent = Intent(this, HomeAct::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun valida(): Boolean {
        var ban = true
        if (binding.etUser.text.toString() != "") {
            binding.inUser.setError(null)
        } else {
            ban = false
            binding.inUser.error = getString(R.string.obligatori_field)
        }
        if (binding.etPassword.text.toString() != "") {
            binding.inPass.setError(null)
        } else {
            ban = false
            binding.inPass.error = getString(R.string.obligatori_field)
        }
        if(ban)
            binding.btnLogin.setBackgroundColor(Color.RED)
        else
            binding.btnLogin.setBackgroundColor(Color.LTGRAY)
        return ban
    }
}