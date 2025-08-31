package com.mercadolivro.controllers.responses

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.models.CustomerModel
import java.math.BigDecimal

class BookResponse (
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var status: BookStatus?,
    var customer: CustomerModel?
)