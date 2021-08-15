package com.momen.retrofitservice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.momen.retrofitservice.R
import com.momen.retrofitservice.di.DaggerHomeComponent
import com.momen.retrofitservice.viewmodel.HomeViewModel
import com.momen.retrofitservice.viewmodel.HomeViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: HomeViewModelFactory

    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectViewModels()
        setUpViewModels()

    }

    private fun injectViewModels() {
        DaggerHomeComponent.builder()
            .build()
            .inject(this)
    }

    private fun setUpViewModels() {
        viewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
    }

}