package com.mercadolivro.controllers.requests.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Name must not be empty")
    var name: String,

    @field:Email(message = "Email must be valid")
    @field:NotEmpty(message = "Email must not be empty")
    var email: String
)