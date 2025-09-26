package com.mercadolivro.services

import com.mercadolivro.events.PurchaseCreatedEvent
import com.mercadolivro.models.PurchaseModel
import com.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val repository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun findAll(pageable: Pageable): Page<PurchaseModel> {
        return repository.findAll(pageable)
    }

    fun create(purchase: PurchaseModel) {
        repository.save<PurchaseModel>(purchase)
        applicationEventPublisher.publishEvent(PurchaseCreatedEvent(this, purchase))
    }

    fun update(purchase: PurchaseModel) {
        repository.save<PurchaseModel>(purchase)
    }
}
