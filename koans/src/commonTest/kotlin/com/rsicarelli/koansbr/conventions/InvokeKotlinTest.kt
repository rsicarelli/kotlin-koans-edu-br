/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.conventions

import com.rsicarelli.koansbr.conventions.invoke.Invokable
import com.rsicarelli.koansbr.conventions.invoke.invokeTwice
import kotlin.test.Test
import kotlin.test.assertEquals

class InvokeKotlinTest {

    @Test
    fun `DADO um Invokable QUANDO ele é invocado duas vezes ENTÃO o número de invocações deve ser 2`() {
        // DADO
        val invokable = Invokable()

        // QUANDO
        invokeTwice(invokable)

        // ENTÃO
        assertEquals(
            expected = 2,
            actual = invokable.numberOfInvocations,
            message = "O número de invocações está incorreto"
        )
    }

    @Test
    fun `DADO um Invokable QUANDO ele é invocado uma vez ENTÃO o número de invocações deve ser 1`() {
        // DADO
        val invokable = Invokable()

        // QUANDO
        invokable()

        // ENTÃO
        assertEquals(
            expected = 1,
            actual = invokable.numberOfInvocations,
            message = "O número de invocações está incorreto"
        )
    }

    @Test
    fun `DADO um Invokable QUANDO ele é invocado cinco vezes ENTÃO o número de invocações deve ser 5`() {
        // DADO
        val invokable = Invokable()

        // QUANDO
        invokable()()()()()

        // ENTÃO
        assertEquals(
            expected = 5,
            actual = invokable.numberOfInvocations,
            message = "O número de invocações está incorreto"
        )
    }

    @Test
    fun `DADO um Invokable QUANDO ele não é invocado ENTÃO o número de invocações deve ser 0`() {
        // DADO
        val invokable = Invokable()

        // ENTÃO
        assertEquals(
            expected = 0,
            actual = invokable.numberOfInvocations,
            message = "O número de invocações está incorreto"
        )
    }
}
