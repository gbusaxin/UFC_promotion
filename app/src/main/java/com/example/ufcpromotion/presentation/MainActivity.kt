package com.example.ufcpromotion.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import coil.imageLoader
import coil.request.Disposable
import coil.request.ImageRequest
import com.example.ufcpromotion.R
import com.example.ufcpromotion.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as UfcApp).component
    }

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            downloadBackgroundImage()
        }
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_news, R.id.navigation_fights, R.id.navigation_pound_for
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun downloadBackgroundImage() {
        val request = ImageRequest
            .Builder(this)
            .data("http://95.217.132.144/ufc/background_image.jpg")
            .target {
                binding.container.background = it
            }
            .build()
        disposable = imageLoader.enqueue(request)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}