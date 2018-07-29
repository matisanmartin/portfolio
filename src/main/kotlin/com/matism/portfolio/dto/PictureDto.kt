package com.matism.portfolio.dto

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty

class PictureDto {

    @field: NotNull
    @field: NotEmpty
    var title: String = ""

    override fun toString(): String {
        return "{title:'$title'}"
    }


}