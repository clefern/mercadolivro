package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ML_0001("ML-001", "Request inválido"),
    ML_101("ML-101", "Cliente [%s] não existe"),
    ML_102("ML-102", "O status [%s] não pode ser alterado"),
    ML_201("ML-201", "Livro [%s] não encontrado"),
    ML_301("ML-301", "Estoque insuficiente para o livro [%s]"),
    ML_302("ML-302", "Livro [%s] fora de estoque"),
    ML_303("ML-303", "Quantidade inválida para compra: [%s]"),
}