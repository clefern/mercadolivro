package com.mercadolivro.services

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
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
        book.stock = 1
        repository.save<BookModel>(book)
    }

    fun findById(id: Int): BookModel {
        return repository.findById(id).orElseThrow { NotFoundException(Errors.ML_201, id.toString()) }
    }

    fun update(book: BookModel) {
        if (!repository.existsById(book.id!!)) {
            println(book.id)
            throw NotFoundException(Errors.ML_201, book.id.toString())
        }
        repository.save<BookModel>(book)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            throw NotFoundException(Errors.ML_201, id.toString())
        }
        val book = findById(id)
        book.status = BookStatus.DELETED
        book.stock = 0
        repository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = repository.findByCustomer(customer)
        for(book in books) {
            book.status = BookStatus.DELETED
        }
        repository.saveAll(books)
    }

    fun findAllByIds(bookIds: Set<Int>): List<BookModel> {
        return repository.findAllById(bookIds).toList()
    }

    fun purchase(book: BookModel) {
        book.status = BookStatus.SOLD
        if (book.stock > 0) {
            book.stock -= 1
        }
        repository.save(book)
    }

    fun purchase(books: MutableList<BookModel>) {
        books.map {
            it.status = BookStatus.SOLD
            if (it.stock > 0) {
                it.stock -= 1
            }
        }
        repository.saveAll(books)
    }
}