/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.helloWorld.start
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTests {

    @Test
    fun `DADO que a função start é chamada, QUANDO nenhum parâmetro for passado, ENTÃO ela deve retornar OK`() {
        // DADO
        // sem estado inicial

        // QUANDO
        val resultado: String = start()

        // ENTÃO
        assertEquals(
            actual = resultado,
            expected = "OK",
        )
    }
}
