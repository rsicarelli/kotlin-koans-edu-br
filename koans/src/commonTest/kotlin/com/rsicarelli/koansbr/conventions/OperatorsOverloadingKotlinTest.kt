/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.conventions

import com.rsicarelli.koansbr.conventions.operatorsoverloading.MyDate
import com.rsicarelli.koansbr.conventions.operatorsoverloading.TimeInterval.DAY
import com.rsicarelli.koansbr.conventions.operatorsoverloading.TimeInterval.WEEK
import com.rsicarelli.koansbr.conventions.operatorsoverloading.TimeInterval.YEAR
import com.rsicarelli.koansbr.conventions.operatorsoverloading.plus
import com.rsicarelli.koansbr.conventions.operatorsoverloading.task1
import com.rsicarelli.koansbr.conventions.operatorsoverloading.task2
import com.rsicarelli.koansbr.conventions.operatorsoverloading.times
import kotlin.test.Test
import kotlin.test.assertEquals

class OperatorsOverloadingKotlinTest {

    @Test
    fun `DADO uma data QUANDO adicionamos 1 ano e 1 semana ENTÃO deve retornar a data correta`() {
        // DADO
        val data = MyDate(year = 2014, month = 5, dayOfMonth = 1)

        // QUANDO
        val resultado: MyDate = task1(data)

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2015, month = 5, dayOfMonth = 8),
            actual = resultado,
            message = "Erro ao adicionar 1 ano e 1 semana à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO adicionamos 2 anos, 3 semanas e 5 dias ENTÃO deve retornar a data correta`() {
        // DADO
        val data = MyDate(year = 2014, month = 0, dayOfMonth = 1)

        // QUANDO
        val resultado: MyDate = task2(data)

        // ENTÃO
        assertEquals(
            expected = MyDate(2016, 0, 27),
            actual = resultado,
            message = "Erro ao adicionar 2 anos, 3 semanas e 5 dias à data inicial"
        )
    }

    @Test
    fun `DADO uma data próxima ao fim do mês QUANDO adicionamos 2 anos, 3 semanas e 5 dias ENTÃO deve retornar a data correta após a mudança do mês`() {
        // DADO
        val data = MyDate(year = 2014, month = 0, dayOfMonth = 25)

        // QUANDO
        val resultado: MyDate = task2(data)

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2016, month = 1, dayOfMonth = 20),
            actual = resultado,
            message = "Erro ao adicionar intervalos de tempo a uma data próxima ao fim do mês"
        )
    }

    @Test
    fun `DADO uma data QUANDO adicionamos 1 dia ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + DAY

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2023, month = 9, dayOfMonth = 11),
            actual = resultado,
            message = "Erro ao adicionar 1 dia à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO adicionamos 1 semana ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + WEEK

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2023, month = 9, dayOfMonth = 17),
            actual = resultado,
            message = "Erro ao adicionar 1 semana à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO adicionamos 1 ano ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + YEAR

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2024, month = 9, dayOfMonth = 10),
            actual = resultado,
            message = "Erro ao adicionar 1 ano à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO multiplicamos um intervalo de 3 dias ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + (DAY * 3)

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2023, month = 9, dayOfMonth = 13),
            actual = resultado,
            message = "Erro ao adicionar intervalo de 3 dias à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO multiplicamos um intervalo de 2 semanas ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + (WEEK * 2)

        // ENTÃO
        assertEquals(
            expected = MyDate(2023, 9, 24),
            actual = resultado,
            message = "Erro ao adicionar intervalo de 2 semanas à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO multiplicamos um intervalo de 4 anos ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + (YEAR * 4)

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2027, month = 9, dayOfMonth = 10),
            actual = resultado,
            message = "Erro ao adicionar intervalo de 4 anos à data inicial"
        )
    }

    @Test
    fun `DADO uma data QUANDO adicionamos uma combinação de dias, semanas e anos ENTÃO deve retornar a data correta`() {
        // QUANDO
        val hoje = MyDate(year = 2023, month = 9, dayOfMonth = 10)
        val resultado: MyDate = hoje + DAY * 5 + WEEK * 2 + YEAR * 3

        // ENTÃO
        assertEquals(
            expected = MyDate(year = 2026, month = 9, dayOfMonth = 27),
            actual = resultado,
            message = "Erro ao adicionar combinação de dias, semanas e anos à data inicial"
        )
    }
}
