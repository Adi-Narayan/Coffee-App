package com.example.coffeeapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.coffeeapp.ViewModel.MainViewModel
import com.example.coffeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE

        viewModel.loadBanner().observe(this) { bannerList ->
            if (!bannerList.isNullOrEmpty()) {
                Glide.with(this@MainActivity)
                    .load(bannerList[0].url)
                    .into(binding.banner)
            }
            binding.progressBarBanner.visibility = View.GONE
        }
    }
}
