package com.mercadolivro.mappers

import com.mercadolivro.controllers.requests.PostPurchaseRequest
import com.mercadolivro.controllers.responses.PurchaseResponse
import com.mercadolivro.models.PurchaseModel
import com.mercadolivro.services.BookService
import com.mercadolivro.services.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    val bookService: BookService,
    val customerService: CustomerService
) {
    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }
        )
    }

    fun toResponse(it: PurchaseModel): PurchaseResponse {
        return PurchaseResponse(
            id = it.id,
            customer = it.customer,
            books = it.books,
            nfe = it.nfe,
            price = it.price,
            createdAt = it.createdAt
        )
    }
}