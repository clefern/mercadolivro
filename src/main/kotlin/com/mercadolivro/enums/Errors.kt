package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ML_0001("ML-001", "Recurso não encontrado"),
    ML_201("ML-201", "Livro não encontrado"),
    ML_101("ML-101", "Cliente não existe");
}