package com.example.reactiveProjectExample.modulo01.repository

import com.example.reactiveProjectExample.modulo01.entity.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ProductRepository : ReactiveCrudRepository<Product, Int> {

    fun findByPriceBetween(from: Int, max: Int): Flux<Product>
    fun findBy(page: Pageable): Flux<Product>
}