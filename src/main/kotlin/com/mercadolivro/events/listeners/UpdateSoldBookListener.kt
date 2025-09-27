package com.mercadolivro.events.listeners

import com.mercadolivro.events.PurchaseCreatedEvent
import com.mercadolivro.services.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {
    @Async
    @EventListener
    fun onPurchaseCreated(event: PurchaseCreatedEvent) {
        bookService.purchase(event.purchase.books)
    }
}