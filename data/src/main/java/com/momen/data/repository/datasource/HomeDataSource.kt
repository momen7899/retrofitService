package com.momen.data.repository.datasource

import com.momen.data.entitty.DataResponseEntity
import io.reactivex.Single

interface HomeDataSource {
    fun getData(pagination: Int): Single<ArrayList<DataResponseEntity>>
}
