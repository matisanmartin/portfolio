package com.matism.portfolio.exception

class InternalServerException(var errorKey: String, override var message: String) : RuntimeException(message){
}