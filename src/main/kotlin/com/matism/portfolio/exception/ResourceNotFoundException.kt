package com.matism.portfolio.exception

class ResourceNotFoundException(var errorKey: String = "error.message.ResourceNotFound", override var message: String) : RuntimeException(message) {
}