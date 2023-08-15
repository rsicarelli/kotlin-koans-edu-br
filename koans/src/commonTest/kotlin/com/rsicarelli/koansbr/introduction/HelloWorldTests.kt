/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.helloWorld.start
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTests {

    @Test
    fun `DADO que o método start seja chamado, QUANDO nenhum parâmetro for passado, ENTÃO o método deve retornar OK`() {
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
