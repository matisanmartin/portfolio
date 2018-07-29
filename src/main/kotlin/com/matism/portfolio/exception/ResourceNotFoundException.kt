package com.matism.portfolio.exception

class ResourceNotFoundException(var errorKey: String, override var message: String) : RuntimeException(message) {
}