/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.lambdas.containsEven
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LambdaTests {

    @Test
    fun `DADO uma coleção contendo um numero par, QUANDO containsEven é chamado, ENTÃO deve retornar true`() {
        val testInputs = listOf(
            "1,2,3,126,555",
            "2",
            "2,4,6,8,10"
        )

        testInputs.forEach { inputString ->
            // DADO
            val evenNumbers: List<Int> = inputString.split(",").map(String::toInt)

            // QUANDO
            val resultado: Boolean = containsEven(evenNumbers)

            // ENTÃO
            assertTrue(
                actual = resultado,
                message = "Resultado deveria ser true para a coleção: $evenNumbers"
            )
        }
    }

    @Test
    fun `DADO uma coleção sem números pares, QUANDO containsEven é chamado, ENTÃO deve retornar false`() {
        val testInputs = listOf(
            "43,33",
            "1",
            "1,3,5,7,9"
        )

        testInputs.forEach { inputString ->
            // DADO
            val oddNumbers: List<Int> = inputString.split(",").map(String::toInt)

            // QUANDO
            val resultado: Boolean = containsEven(oddNumbers)

            // ENTÃO
            assertFalse(
                actual = resultado,
                message = "Resultado deveria ser false para a coleção: $oddNumbers"
            )
        }
    }
}
