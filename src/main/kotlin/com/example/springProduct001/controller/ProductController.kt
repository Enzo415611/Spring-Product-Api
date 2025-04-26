package com.example.springProduct001.controller


import com.example.springProduct001.model.ProductModel
import com.example.springProduct001.repository.RepositoryProduct
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProductController (var repositoryProduct: RepositoryProduct){


    @GetMapping("/produtos")
    fun getAll(): String{
        return repositoryProduct.findAll().toString()
        }

    @GetMapping("/produtos/{id}")
    fun getById(@PathVariable id: Long): String{
        return repositoryProduct.findById(id).toString()
    }

    @PostMapping("/produtos")
    fun save(@RequestBody productModel: ProductModel){
        repositoryProduct.save(productModel)
    }

    @PutMapping("/produtos/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody productModelUpdate: ProductModel
    ): ResponseEntity<ProductModel>{
        val productExists = repositoryProduct.findById(id).orElseThrow { RuntimeException("Produto não encontrado") }

        productExists.nome = productModelUpdate.nome
        productExists.validade = productModelUpdate.validade
        val usuarioSave = repositoryProduct.save(productExists)
        return ResponseEntity.ok(usuarioSave)
    }

    @DeleteMapping("/produtos/{id}")
    fun delete(@PathVariable id: Long,){
        val entity = repositoryProduct.findById(id).orElseThrow{ RuntimeException("Produto não encontrado")}
        repositoryProduct.delete(entity)
    }

}