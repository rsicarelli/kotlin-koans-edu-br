/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

@file:Suppress("NonAsciiCharacters")

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.smartCasts.Expr
import com.rsicarelli.koansbr.classes.smartCasts.Num
import com.rsicarelli.koansbr.classes.smartCasts.Sum
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SmartCastsTests {

    @Test
    fun `DADO uma expressão do tipo específico QUANDO o Smart Cast é usado ENTÃO as propriedades do tipo especifico estao acessiveis`() {

        // DADO
        val expr: Expr = Num(value = 5)

        @Suppress("KotlinConstantConditions", "UseCheckOrError")
        when (expr) {
            // QUANDO
            is Num ->
                // ENTÃO
                assertEquals(5, expr.value)

            //compilador sabe que é impossível chegar nessa linha
            is Sum -> throw IllegalStateException("Isso não deveria acontecer neste teste!")
        }
    }

    @Test
    fun `DADO uma expressão do tipo Num QUANDO eu verifico o tipo ENTÃO consigo acessar as propriedades de Num`() {
        // DADO
        val expr: Expr = Num(value = 2)

        // QUANDO
        if (expr is Num) {
            // ENTÃO
            assertEquals(2, expr.value)
        } else {
            assertFailsWith<AssertionError> {
                @Suppress("UNUSED_EXPRESSION") //compilador sabe que é impossível chegar nessa linha
                "Expr não é do tipo Num"
            }
        }
    }

    @Test
    fun `DADO uma expressão do tipo Sum QUANDO eu verifico o tipo ENTÃO consigo acessar as propriedades de Sum`() {
        // DADO
        val expr: Expr = Sum(Num(value = 2), Num(value = 4))

        // QUANDO
        if (expr is Sum) {
            // ENTÃO
            assertEquals(2, (expr.left as Num).value)
            assertEquals(4, (expr.right as Num).value)
        } else {
            assertFailsWith<AssertionError> {
                @Suppress("UNUSED_EXPRESSION") //compilador sabe que é impossível chegar nessa linha
                "Expr não é do tipo Sum"
            }
        }
    }
}
