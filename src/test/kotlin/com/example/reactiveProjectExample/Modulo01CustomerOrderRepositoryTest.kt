package com.example.reactiveProjectExample

import com.example.reactiveProjectExample.modulo01.repository.CustomerOrderRepository
import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import reactor.test.StepVerifier

class Modulo01CustomerOrderRepositoryTest: AbstractClass() {

    private val log = LogManager.getLogger(Modulo01ProductRepository::class.java)

    @Autowired
    lateinit var customerOrderRepository: CustomerOrderRepository

    @Test
    fun productOrderedByCustomer() {
        StepVerifier.create(
            customerOrderRepository.getProductOrderByCustomer("mike")
        )
            .assertNext { product ->
                kotlin.test.assertNotNull(product)
            }
            .assertNext { product ->
                kotlin.test.assertNotNull(product)
            }
            .verifyComplete()
    }
}