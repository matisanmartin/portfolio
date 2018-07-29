package com.matism.portfolio.controller

import com.matism.portfolio.exception.BadRequestException
import org.springframework.validation.BindingResult

abstract class AbstractController {

    fun validateRequest(bindingResult: BindingResult) {
        if (bindingResult.hasErrors())
            throw BadRequestException("message.error.badRequest", "Invalid parameters")
    }
}