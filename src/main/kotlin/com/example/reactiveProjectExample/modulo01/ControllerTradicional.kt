package com.example.reactiveProjectExample.modulo01

import com.example.reactiveProjectExample.modulo01.dto.Produto
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient


@RestController
@RequestMapping("/traditional")
class ControllerTradicional {

    private val logger: Logger = LogManager.getLogger(ControllerTradicional::class.java)
    private val restClient: RestClient = RestClient.builder().baseUrl("http://localhost:7071").build();

    @GetMapping("/products")
    fun getProducts() : List<Produto> {


        val productsList = restClient.get()
            .uri("/demo01/products")
            .retrieve()
            .body(object : ParameterizedTypeReference<List<Produto>>() {})
            ?: emptyList()

                logger.info ("receive the list {}",productsList )

        return productsList;
    }


}