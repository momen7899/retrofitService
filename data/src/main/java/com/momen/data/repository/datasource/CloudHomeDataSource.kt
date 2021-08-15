package com.momen.data.repository.datasource

import com.momen.data.ConstValues
import com.momen.data.api.WebServiceFactory
import com.momen.data.entitty.DataResponseEntity
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class CloudHomeDataSource @Inject constructor(webServiceFactory: WebServiceFactory):HomeDataSource{

    private val factory = webServiceFactory.createService(HomeWebService::class.java)


    override fun getData(pagination: Int): Single<ArrayList<DataResponseEntity>> =
        factory.getData(pagination)


    interface HomeWebService {
        @GET(ConstValues.GET_URL)
        fun getData(@Query(ConstValues.PAGINATION) pagination: Int): Single<java.util.ArrayList<DataResponseEntity>>
    }

}
