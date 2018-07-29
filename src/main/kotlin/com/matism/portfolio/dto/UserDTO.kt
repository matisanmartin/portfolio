package com.matism.portfolio.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class UserDTO {

    @NotNull
    @NotEmpty
    val userName: String = ""
}