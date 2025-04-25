package com.example.springProduct001.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate


@Entity(name = "product")
@Table(name = "product_Table")
data class ProductModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @NotBlank
    var nome: String,
    @NotBlank
    var validade: String
)