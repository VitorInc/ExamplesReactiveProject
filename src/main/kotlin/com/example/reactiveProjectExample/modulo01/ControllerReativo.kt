package com.example.reactiveProjectExample.modulo01
import com.example.reactiveProjectExample.modulo01.dto.Produto
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.MediaType

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/reativo")
class ControllerReativo {
    private val log: Logger = LogManager.getLogger(ControllerTradicional::class.java)
    private val webClient: WebClient = WebClient.builder().baseUrl("http://localhost:7071").build();

    @GetMapping("/products")
    fun getProducts(): Flux<Produto> {
        return this.webClient
            .get()
            .uri("/demo01/products/notorious")
            .retrieve()
            .bodyToFlux(Produto::class.java)
            .onErrorComplete()
            .doOnNext { p -> log.info("receive data {}", p) }
    }
}