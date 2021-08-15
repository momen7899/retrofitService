package com.momen.retrofitservice.viewmodel

import androidx.lifecycle.ViewModel
import com.momen.domain.interactor.GetDataUseCase
import com.momen.retrofitservice.model.DataMapper

class HomeViewModel(
    private val useCase: GetDataUseCase,
    private val mapper: DataMapper
) : ViewModel() {
}