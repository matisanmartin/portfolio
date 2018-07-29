package com.matism.portfolio.dto

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty

class ProjectDto(

        @field: NotNull
        @field: NotEmpty
        var name: String,

        var description: String
) {
    override fun toString(): String {
        return "{name:'$name', description:'$description'}"
    }
}