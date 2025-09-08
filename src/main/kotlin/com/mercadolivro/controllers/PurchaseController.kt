package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostPurchaseRequest
import com.mercadolivro.mappers.PurchaseMapper
import com.mercadolivro.models.PurchaseModel
import com.mercadolivro.services.PurchaseService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("purchases")
@RequestMapping("purchases")
class PurchaseController(
    private val service: PurchaseService,
    private val mapper: PurchaseMapper
) {

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<PurchaseModel> {
        return service.findAll(pageable)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid req: PostPurchaseRequest) {
        service.create(mapper.toModel(req))
    }
}