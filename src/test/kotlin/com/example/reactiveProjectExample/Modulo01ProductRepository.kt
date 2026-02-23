package com.example.reactiveProjectExample

import com.example.reactiveProjectExample.modulo01.repository.ProductRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import reactor.test.StepVerifier
import kotlin.test.Test

class Modulo01ProductRepository: AbstractClass() {
    private val log = LogManager.getLogger(Modulo01ProductRepository::class.java)

    @Autowired
    lateinit var productRepository: ProductRepository

    @Test
    fun findByPriceRange() {
        StepVerifier.create(productRepository.findByPriceBetween(750, 1000))
            .thenConsumeWhile { product ->
                log.info("Product: id={} price={}", product.id, product.price)
                product.price in 750..1000
            }
            .verifyComplete()
    }

    @Test
    fun findByPriceRange_generic() {
        StepVerifier.create(productRepository.findByPriceBetween(750, 1000))
            .thenConsumeWhile { product ->
                log.info("Product: id={} price={}", product.id, product.price)
                product.price in 750..1000
            }
            .verifyComplete()
    }

    @Test
    fun returPage() {
        StepVerifier.create(
            productRepository.findBy(PageRequest.of(0, 10).withSort(Sort.by("price").ascending()))
        )
            .expectNextCount(10)
            .verifyComplete()
    }


}

