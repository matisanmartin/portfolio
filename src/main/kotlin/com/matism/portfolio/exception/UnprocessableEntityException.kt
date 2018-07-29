package com.matism.portfolio.exception

class UnprocessableEntityException(var errorKey: String, override var message: String) : RuntimeException(message){
}