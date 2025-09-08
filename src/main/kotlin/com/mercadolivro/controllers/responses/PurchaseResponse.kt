package com.mercadolivro.controllers.responses

import com.mercadolivro.models.BookModel
import com.mercadolivro.models.CustomerModel

class PurchaseResponse {
    var id: Int? = null
    var customer: CustomerModel? = null
    var books: List<BookModel>? = null
    var price: Double? = null
}
