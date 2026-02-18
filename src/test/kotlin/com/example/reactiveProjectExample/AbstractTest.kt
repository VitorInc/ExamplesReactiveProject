package com.example.reactiveProjectExample

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    properties = [TestConstants.moduloUm]
)
abstract class AbstractClass {

    protected fun helper(): String {
        return "helper funcionando"
    }
}

object TestConstants {
    const val moduloUm = "moduloUm"
}