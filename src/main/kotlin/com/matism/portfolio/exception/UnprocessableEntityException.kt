package com.matism.portfolio.exception

class UnprocessableEntityException(var errorKey: String = "error.message.UnprocessableEntity", override var message: String) : RuntimeException(message) {
}