package com.example.ufcpromotion.data.mappers

import com.example.ufcpromotion.data.database.model.FixturesDbModel
import com.example.ufcpromotion.data.database.model.ResultDbModel
import com.example.ufcpromotion.data.network.model.FixturesDto
import com.example.ufcpromotion.data.network.model.ResultDto
import com.example.ufcpromotion.domain.pojo.FixturesItem
import com.example.ufcpromotion.domain.pojo.ResultItem
import javax.inject.Inject

class FightsMapper @Inject constructor() {
    fun mapFixturesDtoToDbModel(dto: FixturesDto) = FixturesDbModel(
        id = 0,
        enemy1 = dto.enemy1 ?: "",
        enemy1image = dto.enemy1image ?: "",
        enemy2 = dto.enemy2 ?: "",
        enemy2image = dto.enemy2image ?: "",
        whoWin = dto.whoWin ?: 3,
        number = dto.number ?: "",
        weight = dto.weight ?: ""
    )

    fun mapFixturesDbModelToEntity(dbModel: FixturesDbModel) = FixturesItem(
        enemy1 = dbModel.enemy1,
        enemy1image = dbModel.enemy1image,
        enemy2 = dbModel.enemy2,
        enemy2image = dbModel.enemy2image,
        whoWin = dbModel.whoWin,
        number = dbModel.number,
        weight = dbModel.weight
    )

    fun mapResultDtoToDbModel(dto: ResultDto) = ResultDbModel(
        id = 0,
        enemy1 = dto.enemy1 ?: "",
        enemy1image = dto.enemy1image ?: "",
        enemy2 = dto.enemy2 ?: "",
        enemy2image = dto.enemy2image ?: "",
        whoWin = dto.whoWin ?: 3,
        number = dto.number ?: "",
        weight = dto.weight ?: ""
    )

    fun mapResultDbModelToEntity(dbModel: ResultDbModel) = ResultItem(
        enemy1 = dbModel.enemy1,
        enemy1image = dbModel.enemy1image,
        enemy2 = dbModel.enemy2,
        enemy2image = dbModel.enemy2image,
        whoWin = dbModel.whoWin,
        number = dbModel.number,
        weight = dbModel.weight
    )
}