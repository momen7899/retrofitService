package com.momen.data.mapper

import com.momen.data.entitty.DataResponseEntity
import com.momen.domain.model.DataResponse

class DataEntityMapper {

    fun transform(data: DataResponseEntity?): DataResponse? {
        data?.let {
            return DataResponse(it.text, it.img)
        }
        return null
    }
}