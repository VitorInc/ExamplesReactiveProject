package com.example.reactiveProjectExample.modulo01.dto

import java.util.UUID
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

data class OrderDetails @OptIn(ExperimentalTime::class) constructor(val orderId: UUID, val customName: String, val productName: String, val amount: Int, val orderDate: Instant) {

}
