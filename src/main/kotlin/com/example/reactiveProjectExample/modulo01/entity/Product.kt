package com.example.reactiveProjectExample.modulo01.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("product")
data class Product(
    @Id
    @Column("id")val id: Int? = null,
    @Column("description")val description: String,
    @Column("price")val price: Int
){
}