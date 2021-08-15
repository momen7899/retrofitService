package com.momen.retrofitservice.model

import com.momen.domain.model.DataResponse

class DataMapper {

    fun transform(data: ArrayList<DataResponse>?): ArrayList<DataResponseModel> {
        val list = ArrayList<DataResponseModel>()
        data?.let {
            for (item in it) {
                transformDataResponseToDataResponseModel(item)?.let { it1 -> list.add(it1) }
            }
        }
        return list
    }

    fun transformDataResponseToDataResponseModel(data: DataResponse?):DataResponseModel? {
        data?.let {
            return DataResponseModel(it.text, it.img)
        }
        return null
    }
}