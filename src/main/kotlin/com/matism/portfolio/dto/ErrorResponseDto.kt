package com.matism.portfolio.dto

class ErrorResponseDto(var errorKey: String, var message: String) {

    override fun toString(): String {
        return "{errorKey:'$errorKey', message:'$message'}"
    }
}