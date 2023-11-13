package com.example.infonatest.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import com.example.infonatest.R
import com.example.infonatest.databinding.ActivityHomeBinding
import com.example.infonatest.databinding.ActivityLoginBinding
import com.google.android.material.navigation.NavigationView

class HomeAct : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var actionBatDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setNavigationView()
        setDrawerLayout()
    }
    private fun setNavigationView() {
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val viewHeader: View = LayoutInflater.from(this)
            .inflate(R.layout.header_drawer, navigationView, false)
        navigationView.addHeaderView(viewHeader)
    }
    private fun setDrawerLayout() {
        setSupportActionBar(binding.topAppBar)
        actionBatDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        // abre y cierra al presionar el boton
        actionBatDrawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBatDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sesion_close -> {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.loginAct)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }
}