package com.mercadolivro.events.listeners

import com.mercadolivro.events.PurchaseCreatedEvent
import com.mercadolivro.services.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {
    @Async
    @EventListener
    fun onPurchaseCreated(event: PurchaseCreatedEvent) {
        val nfe = "NFe${UUID.randomUUID().toString()}"
        val purchaseModel = event.purchase.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }
}