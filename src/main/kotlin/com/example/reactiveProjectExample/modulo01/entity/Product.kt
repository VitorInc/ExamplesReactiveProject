package com.example.reactiveProjectExample.modulo01.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("product")
data class Product(
    @Id val id: Int? = null,
    val description: String,
    val price: Int
){
}