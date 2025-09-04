package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ML_0001("ML-001", "Recurso não encontrado"),
    ML_101("ML-101", "Cliente [%s] não existe"),
    ML_102("ML-102", "O status [%s] não pode ser alterado"),
    ML_201("ML-201", "Livro [%s] não encontrado"),
}