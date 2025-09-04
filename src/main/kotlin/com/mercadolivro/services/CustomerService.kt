package com.mercadolivro.services

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exceptions.NotFoundException
import com.mercadolivro.models.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val repository: CustomerRepository,
    val bookService: BookService
) {

    fun getAll(name: String?, pageable: Pageable): Page<CustomerModel> {
        name?.let {
            return repository.findByNameContaining(it, pageable)
        }
        return repository.findAll(pageable)
    }

    fun create(customer: CustomerModel) {
        repository.save<CustomerModel>(customer)
    }

    fun findById(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow { NotFoundException(Errors.ML_101, id.toString()) }
    }

    fun update(customer: CustomerModel) {
        if (!repository.existsById(customer.id!!)) {
            println(customer.id)
            throw NotFoundException(Errors.ML_101, customer.id.toString())
        }
        repository.save<CustomerModel>(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            throw NotFoundException(Errors.ML_101, id.toString())
        }
        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.DELETED
        repository.save(customer)
    }
}