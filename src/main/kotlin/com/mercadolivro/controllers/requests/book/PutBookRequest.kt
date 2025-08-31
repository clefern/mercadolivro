package com.mercadolivro.controllers.requests.book

import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    var price: BigDecimal?,
)