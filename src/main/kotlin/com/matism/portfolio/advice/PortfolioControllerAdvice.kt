package com.matism.portfolio.advice

import com.matism.portfolio.dto.ErrorResponseDto
import com.matism.portfolio.exception.BadRequestException
import com.matism.portfolio.exception.InternalServerException
import com.matism.portfolio.exception.UnprocessableEntityException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class PortfolioControllerAdvice {

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequestExceptionHandler(exception: BadRequestException): ErrorResponseDto {
        return ErrorResponseDto(exception.errorKey, exception.message)
    }

    @ExceptionHandler(InternalServerException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun internalServerErrorExceptionHandler(exception: InternalServerException): ErrorResponseDto {
        return ErrorResponseDto(exception.errorKey, exception.message)
    }


    @ExceptionHandler(UnprocessableEntityException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun unprocessableEntityExceptionErrorHandler(exception: UnprocessableEntityException): ErrorResponseDto {
        return ErrorResponseDto(exception.errorKey, exception.message)
    }


}

