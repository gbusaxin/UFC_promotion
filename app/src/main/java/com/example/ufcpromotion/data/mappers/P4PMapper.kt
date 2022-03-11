package com.example.ufcpromotion.data.mappers

import com.example.ufcpromotion.data.database.model.P4PDbModel
import com.example.ufcpromotion.data.network.model.P4PDto
import com.example.ufcpromotion.domain.pojo.P4PItem
import javax.inject.Inject

class P4PMapper @Inject constructor() {
    fun mapDtoToDbModel(dto: P4PDto) = P4PDbModel(
        name = dto.name ?: "",
        image = dto.image ?: "",
        weight = dto.weight ?: ""
    )

    fun mapDbModelToEntity(dbModel: P4PDbModel) = P4PItem(
        name = dbModel.name,
        image = dbModel.image,
        weight = dbModel.weight
    )
}