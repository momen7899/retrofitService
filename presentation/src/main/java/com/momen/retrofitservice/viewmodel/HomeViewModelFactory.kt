package com.momen.retrofitservice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.momen.domain.interactor.GetDataUseCase
import com.momen.retrofitservice.model.DataMapper

class HomeViewModelFactory (
    private val useCase: GetDataUseCase,
    private val mapper: DataMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                useCase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}