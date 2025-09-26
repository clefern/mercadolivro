package com.mercadolivro.models

import com.mercadolivro.enums.CustomerStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "customers")
data class CustomerModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, length = 120)
    var name: String,

    @Column(nullable = false, length = 160, unique = true)
    var email: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,
) {

}