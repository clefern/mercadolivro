package com.mercadolivro.controllers.requests.book

import com.fasterxml.jackson.annotation.JsonAlias
import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    var price: BigDecimal?,
)