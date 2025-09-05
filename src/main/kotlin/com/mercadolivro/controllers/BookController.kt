package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.book.PutBookRequest
import com.mercadolivro.controllers.requests.book.PostBookRequest
import com.mercadolivro.controllers.responses.BookResponse
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.extensions.toResponse
import com.mercadolivro.services.BookService
import com.mercadolivro.services.CustomerService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
@RequestMapping("books")
class BookController(
    val service: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun findAll(@RequestParam(required = false) name: String?, @PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return service.findAll(pageable).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid req: PostBookRequest) {
        val customer = customerService.findById(req.customerId)
        service.create(req.toBookModel(customer))
    }

    @GetMapping("/active")
    fun findByStatus(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return service.getByActive(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): BookResponse {
        return service.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: PutBookRequest) {
        val book = service.findById(id)
        service.update(request.toBookModel(book))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }
}