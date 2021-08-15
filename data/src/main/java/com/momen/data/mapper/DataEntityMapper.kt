package com.momen.data.mapper

import com.momen.data.entitty.DataResponseEntity
import com.momen.domain.model.DataResponse

class DataEntityMapper {

    fun transform(data: ArrayList<DataResponseEntity>?): ArrayList<DataResponse> {
        val list = ArrayList<DataResponse>()
        data?.let {
            for (item in it) {
                transformDataResponseEntityToDataResponse(item)?.let { it1 -> list.add(it1) }
            }
        }
        return list
    }

    private fun transformDataResponseEntityToDataResponse(data: DataResponseEntity?): DataResponse? {
        data?.let {
            return DataResponse(it.text, it.img)
        }
        return null

    }
}