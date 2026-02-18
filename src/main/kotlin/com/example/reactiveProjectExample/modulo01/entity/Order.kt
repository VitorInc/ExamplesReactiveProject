package com.example.reactiveProjectExample.modulo01.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Table("customer_order")
class CustomerOrder @OptIn(ExperimentalTime::class) constructor(
    @Id val orderId: UUID? = null,
    val customerId: Int,
    val productId: Int,
    val amount: Int,
    val orderDate: Instant? = null
) {
}