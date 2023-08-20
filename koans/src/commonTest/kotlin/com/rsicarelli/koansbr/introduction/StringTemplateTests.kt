/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.stringTemplates.getPattern
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringTemplateTests {

    @Test
    fun `DADO um mês, QUANDO getPattern for chamado, ENTÃO deve conter o mês passado no meio do resultado`() {
        val testInputs: List<String> = listOf(
            "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
            "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
        )

        testInputs.forEach { month ->
            // QUANDO
            val resultado: String = getPattern()

            // ENTÃO
            assertTrue(
                actual = resultado.contains(month),
                message = "O padrão não contém o mês esperado. Padrão: $resultado, Mes Esperado: $month"
            )
        }
    }

    @Test
    fun `DADO a string 11 MAR 1952, QUANDO combinada com o padrão, ENTÃO deve corresponder`() {
        // DADO
        val entrada = "11 MAR 1952"

        // QUANDO
        val corresponde: Boolean = entrada.matches(getPattern().toRegex())

        // ENTÃO
        assertTrue(
            actual = corresponde,
            message = "O padrão deve corresponder a $entrada"
        )
    }

    @Test
    fun `DADO a string 24 AUG 1957, QUANDO combinada com o padrão, ENTÃO deve corresponder`() {
        // DADO
        val entrada = "24 AUG 1957"

        // QUANDO
        val corresponde: Boolean = entrada.matches(getPattern().toRegex())

        // ENTÃO
        assertTrue(
            actual = corresponde,
            message = "O padrão deve corresponder a $entrada"
        )
    }

    @Test
    fun `DADO a string 24 RRR 1957, QUANDO combinada com o padrão, ENTÃO não deve corresponder`() {
        // DADO
        val entrada = "24 RRR 1957"

        // QUANDO
        val corresponde: Boolean = entrada.matches(getPattern().toRegex())

        // ENTÃO
        assertFalse(
            actual = corresponde,
            message = "O padrão não deve corresponder a $entrada"
        )
    }
}
