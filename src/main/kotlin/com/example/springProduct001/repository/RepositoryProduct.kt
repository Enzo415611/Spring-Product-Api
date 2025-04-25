package com.example.springProduct001.repository

import com.example.springProduct001.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepositoryProduct : JpaRepository<ProductModel, Long>