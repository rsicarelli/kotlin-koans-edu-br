/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.nothingType.checkAge
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NothingTypeTests {

    @Test
    fun `DADO idade nula, QUANDO checkAge é chamado, ENTÃO deve lançar IllegalArgumentException`() {
        // DADO
        val idade: Int? = null

        // QUANDO / ENTÃO
        val exception: IllegalArgumentException = assertFailsWith<IllegalArgumentException> {
            checkAge(idade)
        }
        assertTrue(exception.message == "Wrong age: null")
    }

    @Test
    fun `DADO idade negativa, QUANDO checkAge é chamado, ENTÃO deve lançar IllegalArgumentException`() {
        // DADO
        val idade = -1

        // QUANDO / ENTÃO
        val exception: IllegalArgumentException = assertFailsWith<IllegalArgumentException> {
            checkAge(idade)
        }
        assertTrue(exception.message == "Wrong age: $idade")
    }

    @Test
    fun `DADO idade muito alta, QUANDO checkAge é chamado, ENTÃO deve lançar IllegalArgumentException`() {
        // DADO
        val idade = 151

        // QUANDO / ENTÃO
        val exception: IllegalArgumentException = assertFailsWith<IllegalArgumentException> {
            checkAge(idade)
        }
        assertTrue(exception.message == "Wrong age: $idade")
    }

    @Test
    fun `DADO idade aceitável, QUANDO checkAge é chamado, ENTÃO a mensagem correta deve ser impressa`() {
        // DADO
        val idade = 25
        val nextAgeOutput = ByteArrayOutputStream()
        val oldOut = System.out
        System.setOut(PrintStream(nextAgeOutput))

        // QUANDO
        checkAge(idade)

        // ENTÃO
        assertEquals("Congrats! Next year you'll be ${idade + 1}.\n", nextAgeOutput.toString())

        // Restaurar o output do console
        System.setOut(oldOut)
    }

}
