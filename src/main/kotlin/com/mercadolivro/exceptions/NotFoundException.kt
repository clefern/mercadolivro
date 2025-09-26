package com.mercadolivro.exceptions

import com.mercadolivro.enums.Errors

class NotFoundException(
    error: Errors, field: String? = ""
) : Exception() {
    override var message: String = error.message.format(field)
    var errorCode: String = error.code
}