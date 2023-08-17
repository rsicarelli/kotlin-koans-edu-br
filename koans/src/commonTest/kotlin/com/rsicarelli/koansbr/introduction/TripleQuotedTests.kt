/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.tripleQuotedStrings.tripleQuotedString
import kotlin.test.Test
import kotlin.test.assertEquals

class TripleQuotedTests {

    @Test
    fun `DADO pergunta e resposta, QUANDO tripleQuotedString for executado, ENTÃO deve retornar uma string correta`() {
        // DADO
        val outputEsperado: String = """
        question = "life, the universe, and everything"
        answer = 42
    """.trimIndent()

        // QUANDO
        val output: String = tripleQuotedString

        // ENTÃO
        assertEquals(
            actual = output,
            expected = outputEsperado,
        )
    }
}
