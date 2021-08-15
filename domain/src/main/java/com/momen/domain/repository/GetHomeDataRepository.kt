package com.momen.domain.repository

import com.momen.domain.model.DataResponse
import io.reactivex.Single

interface GetHomeDataRepository {
    fun getData(pagination: Int): Single<ArrayList<DataResponse>>?
}