package com.mercadolivro.services

import com.mercadolivro.models.PurchaseModel
import com.mercadolivro.repository.PurchaseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    val repository: PurchaseRepository
) {
    fun findAll(pageable: Pageable): Page<PurchaseModel> {
        return repository.findAll(pageable)
    }

    fun create(purchase: PurchaseModel) {
        repository.save<PurchaseModel>(purchase)
    }
}
