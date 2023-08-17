/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.extensionFunctions.RationalNumber
import com.rsicarelli.koansbr.classes.extensionFunctions.r
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionsFunctionsTest {

    @Test
    fun `DADO um número inteiro, QUANDO r() é chamada, ENTÃO deve retornar o número racional correto`() {
        val testInputs = listOf(0, -3, 2, 5, -13)

        for (input in testInputs) {
            // QUANDO
            val resultado: RationalNumber = input.r()

            // ENTÃO
            assertEquals(
                expected = RationalNumber(
                    numerator = input,
                    denominator = 1
                ),
                actual = resultado
            )
        }
    }

    @Test
    fun `DADO um par de inteiros, QUANDO r() é chamada, ENTÃO deve retornar o número racional correto`() {
        val testInputs: List<Pair<Int, Int>> = listOf(
            Pair(1, 2),
            Pair(-3, 7),
            Pair(2, 5),
            Pair(8, -13)
        )

        testInputs.forEach { input ->
            val (expectedNumerator, expectedDenominator) = input

            // QUANDO
            val resultado: RationalNumber = input.r()

            // ENTÃO
            assertEquals(
                expected = RationalNumber(
                    numerator = expectedNumerator,
                    denominator = expectedDenominator
                ),
                actual = resultado
            )
        }
    }
}
