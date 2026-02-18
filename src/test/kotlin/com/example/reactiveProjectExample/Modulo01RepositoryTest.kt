package com.example.reactiveProjectExample
import com.example.reactiveProjectExample.modulo01.repository.UserRepository
import org.apache.logging.log4j.LogManager
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
                kotlin.test.assertNotNull(user.id, user.id.toString())

            }
            .verifyComplete()

    }



}