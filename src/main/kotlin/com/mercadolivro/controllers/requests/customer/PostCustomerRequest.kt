package com.mercadolivro.controllers.requests.customer

import com.mercadolivro.validations.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Name must not be empty")
    var name: String,

    @field:Email(message = "Email must be valid")
    @field:NotEmpty(message = "Email must not be empty")
    @EmailAvailable
    var email: String
)