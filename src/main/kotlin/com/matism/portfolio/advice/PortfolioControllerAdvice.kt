package com.matism.portfolio.advice

import com.matism.portfolio.dto.ErrorResponseDto
import com.matism.portfolio.exception.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class PortfolioControllerAdvice {

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequestException(exception: BadRequestException) =
            ErrorResponseDto(exception.errorKey, exception.message)

}