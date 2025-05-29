package com.example.coffeeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.Domain.BannerModel
import com.example.coffeeapp.Repository.MainRepository

class MainViewModel:ViewModel() {

    private val repository=MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }
}