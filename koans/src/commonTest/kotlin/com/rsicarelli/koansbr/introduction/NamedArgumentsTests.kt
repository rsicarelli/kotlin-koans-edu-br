/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.namedArguments.joinOptions
import kotlin.test.Test
import kotlin.test.assertEquals

class NamedArgumentsTests {

    @Test
    fun `DADO uma lista de opções, QUANDO a função joinOptions é chamado, ENTÃO deve retornar as opções em uma String formatada corretamente`() {
        // DADO
        val options: List<String> = listOf("opção1", "opção2", "opção3")

        // QUANDO
        val resultado: String = joinOptions(options)

        // ENTÃO
        assertEquals(
            actual = resultado,
            expected = "[opção1, opção2, opção3]",
        )
    }

    @Test
    fun `DADO uma lista vazia, QUANDO a função joinOptions é chamado, ENTÃO deve retornar uma String com brackets vazios`() {
        // DADO
        val options: List<String> = emptyList()

        // QUANDO
        val resultado: String = joinOptions(options)

        // ENTÃO
        assertEquals(
            actual = resultado,
            expected = "[]",
        )
    }
}
