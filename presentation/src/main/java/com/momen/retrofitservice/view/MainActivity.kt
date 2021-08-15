package com.momen.retrofitservice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.momen.retrofitservice.R
import com.momen.retrofitservice.di.DaggerHomeComponent
import com.momen.retrofitservice.viewmodel.HomeViewModel
import com.momen.retrofitservice.viewmodel.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: HomeViewModelFactory

    private var viewModel: HomeViewModel? = null
    private val adapter = DataAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectViewModels()
        setUpViewModels()
        setUpComponents()

    }


    private fun injectViewModels() {
        DaggerHomeComponent.builder()
            .build()
            .inject(this)
    }

    private fun setUpComponents() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpViewModels() {
        viewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
    }

}