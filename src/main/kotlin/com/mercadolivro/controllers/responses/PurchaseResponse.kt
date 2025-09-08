package com.mercadolivro.controllers.responses

import com.mercadolivro.models.BookModel
import com.mercadolivro.models.CustomerModel
import java.math.BigDecimal
import java.time.LocalDateTime

class PurchaseResponse(
    var id: Int?,
    var customer: CustomerModel,
    var books: List<BookModel>,
    var nfe: String? = null,
    var price: BigDecimal? = null,
    var createdAt: LocalDateTime
)
