package com.example.ufcpromotion.utils

interface MapperUtil<Item, Dto, DbModel> {
    fun mapDtoToDbModel(dto: Dto): DbModel
    fun mapDbModelToEntity(dbModel: DbModel): Item
}