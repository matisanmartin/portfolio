package com.matism.portfolio.exception

class BadRequestException(var errorKey: String, override var message: String) : RuntimeException(message){
}