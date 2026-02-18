package com.example.reactiveProjectExample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication(
    scanBasePackages = ["com.example.reactiveProjectExample.${"moduloUm"}}"]
)
@EnableR2dbcRepositories(
    basePackages = ["com.example.reactiveProjectExample.${"moduloUm"}}"]
)class ReactiveProjectExampleApplication

fun main(args: Array<String>) {
	runApplication<ReactiveProjectExampleApplication>(*args)
}
