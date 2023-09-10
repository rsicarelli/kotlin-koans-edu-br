/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.conventions

import com.rsicarelli.koansbr.conventions.ranges.MyDate
import com.rsicarelli.koansbr.conventions.ranges.checkInRange
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RangesKotlinTest {

    @Test
    fun `DADO um intervalo de datas QUANDO verificamos uma data dentro desse intervalo ENTÃO ela deve estar no intervalo`() {
        // DADO
        val data = MyDate(year = 2014, month = 3, dayOfMonth = 22)
        val inicio = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val fim = MyDate(year = 2015, month = 1, dayOfMonth = 1)

        // QUANDO
        val estaNoIntervalo = checkInRange(date = data, first = inicio, last = fim)

        // ENTÃO
        assertTrue(
            actual = estaNoIntervalo,
            message = "Esperado que a data $data esteja no intervalo $inicio..$fim"
        )
    }

    @Test
    fun `DADO um intervalo de datas QUANDO verificamos uma data exatamente no início desse intervalo ENTÃO ela deve estar no intervalo`() {
        // DADO
        val data = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val inicio = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val fim = MyDate(year = 2015, month = 1, dayOfMonth = 1)

        // QUANDO
        val estaNoIntervalo = checkInRange(date = data, first = inicio, last = fim)

        // ENTÃO
        assertTrue(
            actual = estaNoIntervalo,
            message = "Esperado que a data $data esteja no intervalo $inicio..$fim"
        )
    }

    @Test
    fun `DADO um intervalo de datas QUANDO verificamos uma data exatamente no fim desse intervalo ENTÃO ela deve estar no intervalo`() {
        // DADO
        val data = MyDate(year = 2015, month = 1, dayOfMonth = 1)
        val inicio = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val fim = MyDate(year = 2015, month = 1, dayOfMonth = 1)

        // QUANDO
        val estaNoIntervalo = checkInRange(date = data, first = inicio, last = fim)

        // ENTÃO
        assertTrue(
            actual = estaNoIntervalo,
            message = "Esperado que a data $data esteja no intervalo $inicio..$fim"
        )
    }

    @Test
    fun `DADO um intervalo de datas QUANDO verificamos uma data anterior a esse intervalo ENTÃO ela não deve estar no intervalo`() {
        // DADO
        val data = MyDate(year = 2013, month = 3, dayOfMonth = 22)
        val inicio = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val fim = MyDate(year = 2015, month = 1, dayOfMonth = 1)

        // QUANDO
        val estaNoIntervalo = checkInRange(date = data, first = inicio, last = fim)

        // ENTÃO
        assertFalse(
            actual = estaNoIntervalo,
            message = "Esperado que a data $data não esteja no intervalo $inicio..$fim"
        )
    }

    @Test
    fun `DADO um intervalo de datas QUANDO verificamos uma data posterior a esse intervalo ENTÃO ela não deve estar no intervalo`() {
        // DADO
        val data = MyDate(year = 2015, month = 3, dayOfMonth = 22)
        val inicio = MyDate(year = 2014, month = 1, dayOfMonth = 1)
        val fim = MyDate(year = 2015, month = 1, dayOfMonth = 1)

        // QUANDO
        val estaNoIntervalo = checkInRange(date = data, first = inicio, last = fim)

        // ENTÃO
        assertFalse(
            actual = estaNoIntervalo,
            message = "Esperado que a data $data não esteja no intervalo $inicio..$fim"
        )
    }
}
