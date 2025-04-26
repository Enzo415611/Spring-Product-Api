package com.example.springProduct001.model

import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDate


@Entity(name = "products")
@Table(name = "products_table")
data class ProductModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    @Size(min = 1, message = "Nome deve ter de 1 a 50 caracteres")
    @NotBlank(message = "nome é obrigatorio")
    var nome: String,

    @Column(nullable = false)
    @NotNull(message = "Deve especificar a validade")
    var validade: LocalDate,

    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.0", message = "Peso deve ser maior que zero")
    @NotNull(message = "Peso é obrigatório")
    var peso: BigDecimal,

    @Column(nullable = false)
    @NotNull(message = "Deve especificar se é consumível")
    var consumivel: Boolean,
)