package com.momen.data.repository.datasource

import javax.inject.Inject

class HomeDataSourceFactory @Inject constructor(private val homeDataSource: CloudHomeDataSource) {
    fun create(): HomeDataSource = homeDataSource
}
