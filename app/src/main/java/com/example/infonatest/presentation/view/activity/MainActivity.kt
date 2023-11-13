package com.example.infonatest.presentation.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.infonatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animation = AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in)
        //starting the animation
        binding.SplashScreenImage.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginAct::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}