package com.mercadolivro.events.listeners

import com.mercadolivro.services.BookService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @EventListener
    fun onPurchaseCreated(event: com.mercadolivro.events.PurchaseCreatedEvent) {
        bookService.purchase(event.purchase.books)
    }
}