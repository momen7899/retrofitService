package com.momen.data.repository

import android.annotation.SuppressLint
import com.momen.data.mapper.DataEntityMapper
import com.momen.data.repository.datasource.HomeDataSourceFactory
import com.momen.domain.model.DataResponse
import com.momen.domain.repository.GetHomeDataRepository
import io.reactivex.Single

class GetHomeDataRepositoryImpl(
    private val factory: HomeDataSourceFactory,
    private val mapper: DataEntityMapper
) : GetHomeDataRepository {

    @SuppressLint("CheckResult")
    override fun getData(pagination: Int): Single<ArrayList<DataResponse>> =
        factory.create().getData(pagination).map(mapper::transform)

}