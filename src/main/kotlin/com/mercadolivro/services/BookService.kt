package com.mercadolivro.services

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.exceptions.NotFoundException
import com.mercadolivro.models.BookModel
import com.mercadolivro.models.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val repository: BookRepository
) {

    fun findAll(pageable: Pageable): Page<BookModel> {
        return repository.findAll(pageable)
    }

    fun getByActive(pageable: Pageable): Page<BookModel> {
        return repository.findByStatus(BookStatus.ACTIVE, pageable)
    }

    fun create(book: BookModel) {
        repository.save<BookModel>(book)
    }

    fun findById(id: Int): BookModel {
        return repository.findById(id).orElseThrow { NotFoundException("Livro não encontrado", "ML-0002") }
    }

    fun update(book: BookModel) {
        if (!repository.existsById(book.id!!)) {
            println(book.id)
            throw NotFoundException("Livro não encontrado", "ML-0002")
        }
        repository.save<BookModel>(book)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            throw NotFoundException("Livro não encontrado", "ML-0002")
        }
        val book = findById(id)
        book.status = BookStatus.DELETED
        repository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = repository.findByCustomer(customer)
        for(book in books) {
            book.status = BookStatus.DELETED
        }
        repository.saveAll<BookModel>(books)
    }
}