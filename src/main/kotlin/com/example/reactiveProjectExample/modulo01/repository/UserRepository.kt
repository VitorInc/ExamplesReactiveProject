package com.example.reactiveProjectExample.modulo01.repository

import Customer
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface UserRepository: ReactiveCrudRepository<Customer, Int> {


    @Query("SELECT * FROM customer WHERE id = :id" )
    fun findById(name: String): Mono<Customer>

    @Query("SELECT * FROM customer WHERE name = :name" )
    fun findByName(name: String): Flux<Customer>

    @Query("SELECT * FROM customer WHERE email = :email" )
    fun findByEmail(email: String): Flux<Customer>

    fun findByEmailEndingWith(email: String): Flux<Customer>
}