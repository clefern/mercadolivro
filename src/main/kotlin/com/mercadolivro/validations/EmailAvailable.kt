package com.mercadolivro.validations

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Suppress("unused")
@Constraint(validatedBy = [EmailAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)

annotation class EmailAvailable(
    val message: String = "Email is already in use",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
