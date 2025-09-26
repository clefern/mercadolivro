package com.mercadolivro.controllers.responses

import com.mercadolivro.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)