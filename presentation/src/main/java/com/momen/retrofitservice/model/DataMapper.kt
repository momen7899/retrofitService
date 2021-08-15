package com.momen.retrofitservice.model

import com.momen.domain.model.DataResponse

class DataMapper {

    fun transform(data: DataResponse?): DataResponseModel? {
        data?.let {
            return DataResponseModel(it.text, it.img)
        }
        return null
    }
}