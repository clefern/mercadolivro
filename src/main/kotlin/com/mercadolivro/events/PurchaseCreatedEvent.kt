package com.mercadolivro.events

import com.mercadolivro.models.PurchaseModel
import com.mercadolivro.services.PurchaseService
import org.springframework.context.ApplicationEvent

class PurchaseCreatedEvent(
    source: Any,
    var purchase: PurchaseModel
): ApplicationEvent(source)
