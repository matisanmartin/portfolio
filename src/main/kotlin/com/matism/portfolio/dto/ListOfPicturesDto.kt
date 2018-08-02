package com.matism.portfolio.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ListOfPicturesDto {

    @field: NotEmpty
    @field: NotNull
    var pictures: MutableList<PictureDto> = mutableListOf()

    override fun toString(): String {
        return "{pictures:$pictures}"
    }


}