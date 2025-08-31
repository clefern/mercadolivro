package com.mercadolivro.exceptions

class NotFoundException(
    override var message: String,
    var errorCode: String
) : Exception() {
}