package com.mercadolivro.controllers.requests.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PutCustomerRequest(

    @field:NotEmpty(message = "Name must not be empty")
    var name: String?,

    @field:NotEmpty(message = "Email must not be empty")
    @field:Email
    var email: String?
)