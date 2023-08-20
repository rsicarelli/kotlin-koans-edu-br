/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.defaultArguments.foo
import com.rsicarelli.koansbr.introduction.defaultArguments.useFoo
import kotlin.test.Test
import kotlin.test.assertEquals

class DefaultArgumentsTests {

    @Test
    fun `DADO um nome e um número, QUANDO a função foo é chamada, ENTÃO ela deve retornar a concatenação do nome e número`() {
        // DADO
        val name = "test"
        val number = 123

        // QUANDO
        val resultado: String = foo(
            name = name,
            number = number
        )

        // ENTÃO
        val expected = "test123"
        assertEquals(
            expected = expected,
            actual = resultado,
            message = "A concatenação do nome e número: $resultado não segue o esperado $expected"
        )
    }

    @Test
    fun `DADO um nome e um número, com a opção de tornar maiúsculo, QUANDO a função foo é chamada, ENTÃO ela deve retornar a concatenação do nome (em maiúsculas) e número`() {
        // DADO
        val name = "test"
        val number = 123

        // QUANDO
        val resultado: String = foo(
            name = name,
            number = number,
            toUpperCase = true
        )

        // ENTÃO
        val expected = "TEST123"
        assertEquals(
            expected = expected,
            actual = resultado,
            message = "A concatenação do nome (em maiúsculo) e número: $resultado não segue o esperado $expected"
        )
    }

    @Test
    fun `QUANDO a função useFoo é chamada, ENTÃO ela deve retornar uma lista com strings formatadas corretamente`() {
        // QUANDO
        val resultado: List<String> = useFoo()

        // ENTÃO
        val expectedResult: List<String> = listOf("a42", "b1", "C42", "D2")
        assertEquals(
            expected = expectedResult,
            actual = resultado,
            message = "A lista de strings retornada ${resultado.joinToString(",") { it }} não segue o esperado: $expectedResult"
        )
    }
}
