package com.mercadolivro.controllers.responses

data class FieldErrorResponse (
    var message: String,
    var field: String
)