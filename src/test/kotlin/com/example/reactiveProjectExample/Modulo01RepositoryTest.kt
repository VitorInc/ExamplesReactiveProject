package com.example.reactiveProjectExample
import Customer
import com.example.reactiveProjectExample.modulo01.repository.UserRepository
import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import reactor.test.StepVerifier
import kotlin.test.Test

class Modulo01RepositoryTest: AbstractClass() {

    @Autowired
    lateinit var customerRepository: UserRepository

    private val log = LogManager.getLogger(Modulo01RepositoryTest::class.java)


    @Test
    fun testfindAll() {

        StepVerifier.create(customerRepository.findAll())
            .expectNextCount(10) // 10 registros no seu H2
            .verifyComplete()
    }

    @Test
    fun findById() {

        StepVerifier.create(customerRepository.findById(3))
            .assertNext { user ->
                log.info("User = {}", user)
                kotlin.test.assertEquals("jake", user.name)
            }
            .verifyComplete()
    }

    @Test
    fun testfindByName() {


        StepVerifier.create(customerRepository.findByName("jake"))
            .assertNext { user ->
                log.info("doOnNext = {}", user)
                kotlin.test.assertEquals("jake", user.name)
            }
            .verifyComplete()

    }

    @Test
    fun findByEmail() {


        StepVerifier.create(customerRepository.findByEmail("jake@gmail.com"))
            .assertNext { user ->
                log.info("doOnNext = {}", user.id)
                kotlin.test.assertEquals("jake@gmail.com", user.email)

            }
            .verifyComplete()

    }

    @Test
    fun findByEmailEndingWith() {
        StepVerifier.create ( customerRepository.findByEmailEndingWith("ke@gmail.com"))
            .assertNext{user ->
                log.info("doOnNext = {}", user.id)
                kotlin.test.assertEquals("jake@gmail.com", user.email)
                kotlin.test.assertEquals("mike@gmail.com", user.email)

            }
    }

    @Test
    fun insertAndDeleteCustomer_verifyDeletion() {
        val customer = Customer(
            name = "marshal",
            email = "marshal@gmail.com"
        )
        log.info("Inserting customer: {}", customer)

        StepVerifier.create(
            customerRepository.save(customer)
                .flatMap { saved ->
                    log.info("Saved customer: {}", saved)
                    assertEquals("marshal@gmail.com", saved.email)

                    customerRepository.deleteById(saved.id!!).thenReturn(saved.id)
                }
                .flatMap { id ->
                    customerRepository.findById(id)
                }
        )
            .expectNextCount(0)
            .verifyComplete()
    }

}