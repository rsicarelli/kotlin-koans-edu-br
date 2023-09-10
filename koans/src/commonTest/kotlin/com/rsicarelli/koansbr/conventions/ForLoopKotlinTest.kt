package com.rsicarelli.koansbr.conventions

import com.rsicarelli.koansbr.conventions.forloop.DateRange
import com.rsicarelli.koansbr.conventions.forloop.MyDate
import com.rsicarelli.koansbr.conventions.forloop.followingDate
import com.rsicarelli.koansbr.conventions.forloop.iterateOverDateRange
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ForLoopKotlinTest {

    @Test
    fun `DADO um intervalo de datas, QUANDO iteramos sobre ele, ENTÃO devemos obter todas as datas no intervalo`() {
        // DADO
        val actualDateRange: ArrayList<MyDate> = arrayListOf()
        val primeiraData = MyDate(2016, 5, 1)
        val segundaData = MyDate(2016, 5, 5)

        // QUANDO
        iterateOverDateRange(firstDate = primeiraData, secondDate = segundaData) { date ->
            actualDateRange.add(date)
        }

        // ENTÃO
        val expectedDateRange: ArrayList<MyDate> = arrayListOf(
            MyDate(year = 2016, month = 5, dayOfMonth = 1),
            MyDate(year = 2016, month = 5, dayOfMonth = 2),
            MyDate(year = 2016, month = 5, dayOfMonth = 3),
            MyDate(year = 2016, month = 5, dayOfMonth = 4),
            MyDate(year = 2016, month = 5, dayOfMonth = 5)
        )

        assertEquals(
            expected = expectedDateRange,
            actual = actualDateRange,
            message = "Iteração incorreta sobre as datas."
        )
    }

    @Test
    fun `DADO um intervalo de datas vazio, QUANDO iteramos sobre ele, ENTÃO o manipulador não deve ser invocado`() {
        // DADO
        var invoked = false
        val primeiraData = MyDate(2016, 1, 1)
        val segundaData = MyDate(2015, 1, 1)

        // QUANDO
        iterateOverDateRange(firstDate = primeiraData, secondDate = segundaData) {
            invoked = true
        }

        // ENTÃO
        assertFalse(
            actual = invoked,
            message = "O manipulador foi invocado em um intervalo vazio."
        )
    }

    @Test
    fun `DADO um intervalo de datas com a mesma data de início e fim, QUANDO iteramos sobre ele, ENTÃO devemos obter apenas essa data`() {
        // DADO
        val actualDateRange: ArrayList<MyDate> = arrayListOf()
        val data = MyDate(year = 2016, month = 5, dayOfMonth = 5)

        // QUANDO
        iterateOverDateRange(firstDate = data, secondDate = data) { date ->
            actualDateRange.add(date)
        }

        // ENTÃO
        val expectedDateRange: ArrayList<MyDate> = arrayListOf(
            MyDate(year = 2016, month = 5, dayOfMonth = 5)
        )
        assertEquals(
            expected = expectedDateRange,
            actual = actualDateRange,
            message = "Iteração incorreta sobre a mesma data de início e fim."
        )
    }

    @Test
    fun `DADO um intervalo de datas que abrange a mudança do mês, QUANDO iteramos sobre ele, ENTÃO devemos obter todas as datas no intervalo`() {
        // DADO
        val actualDateRange: ArrayList<MyDate> = arrayListOf()
        val primeiraData = MyDate(year = 2016, month = 4, dayOfMonth = 29)
        val segundaData = MyDate(year = 2016, month = 5, dayOfMonth = 2)

        // QUANDO
        iterateOverDateRange(firstDate = primeiraData, secondDate = segundaData) { date ->
            actualDateRange.add(date)
        }

        // ENTÃO
        val expectedDateRange: ArrayList<MyDate> = arrayListOf(
            MyDate(year = 2016, month = 4, dayOfMonth = 29),
            MyDate(year = 2016, month = 4, dayOfMonth = 30),
            MyDate(year = 2016, month = 5, dayOfMonth = 1),
            MyDate(year = 2016, month = 5, dayOfMonth = 2)
        )
        assertEquals(
            expected = expectedDateRange,
            actual = actualDateRange,
            message = "Iteração incorreta sobre datas que abrangem a mudança do mês."
        )
    }

    @Test
    fun `DADO um intervalo de datas que abrange a mudança do ano, QUANDO iteramos sobre ele, ENTÃO devemos obter todas as datas no intervalo`() {
        // DADO
        val actualDateRange: ArrayList<MyDate> = arrayListOf()
        val primeiraData = MyDate(year = 2015, month = 12, dayOfMonth = 31)
        val segundaData = MyDate(year = 2016, month = 1, dayOfMonth = 2)

        // QUANDO
        iterateOverDateRange(firstDate = primeiraData, secondDate = segundaData) { date ->
            actualDateRange.add(date)
        }

        // ENTÃO
        val expectedDateRange: ArrayList<MyDate> = arrayListOf(
            MyDate(year = 2015, month = 12, dayOfMonth = 31),
            MyDate(year = 2016, month = 1, dayOfMonth = 1),
            MyDate(year = 2016, month = 1, dayOfMonth = 2)
        )
        assertEquals(
            expected = expectedDateRange,
            actual = actualDateRange,
            message = "Iteração incorreta sobre datas que abrangem a mudança do ano."
        )
    }

    @Test
    fun `DADO um intervalo no mesmo mês com dia de início maior que dia de fim, QUANDO iteramos, ENTÃO o manipulador não deve ser invocado`() {
        // DADO
        var invoked = false
        val primeiraData = MyDate(year = 2016, month = 5, dayOfMonth = 10)
        val segundaData = MyDate(year = 2016, month = 5, dayOfMonth = 5)

        // QUANDO
        iterateOverDateRange(firstDate = primeiraData, secondDate = segundaData) {
            invoked = true
        }

        // ENTÃO
        assertFalse(
            actual = invoked,
            message = "O manipulador foi invocado em um intervalo inválido."
        )
    }

    @Test
    fun `DADO um intervalo no mesmo ano com mês de início maior que mês de fim, QUANDO iteramos, ENTÃO o manipulador não deve ser invocado`() {
        // DADO
        var invoked = false
        val primeiraData = MyDate(year = 2016, month = 6, dayOfMonth = 5)
        val segundaData = MyDate(year = 2016, month = 5, dayOfMonth = 5)

        // QUANDO
        iterateOverDateRange(primeiraData, segundaData) {
            invoked = true
        }

        // ENTÃO
        assertFalse(
            actual = invoked,
            message = "O manipulador foi invocado em um intervalo inválido."
        )
    }

    @Test
    fun `DADO uma data no final de fevereiro em um ano bissexto, QUANDO pegamos a data seguinte, ENTÃO ela deve ser 1 de março`() {
        // DADO
        val data = MyDate(year = 2016, month = 2, dayOfMonth = 29) // 2016 é um ano bissexto

        // QUANDO
        val nextDate: MyDate = data.followingDate()

        // ENTÃO
        val expectedDate = MyDate(year = 2016, month = 3, dayOfMonth = 1)
        assertEquals(
            expected = expectedDate,
            actual = nextDate,
            message = "Data seguinte incorreta para o final de fevereiro em um ano bissexto."
        )
    }

    @Test
    fun `DADO uma data no final de dezembro, QUANDO pegamos a data seguinte, ENTÃO ela deve ser 1 de janeiro do próximo ano`() {
        // DADO
        val data = MyDate(year = 2016, month = 12, dayOfMonth = 31)

        // QUANDO
        val nextDate: MyDate = data.followingDate()

        // ENTÃO
        val expectedDate = MyDate(year = 2017, month = 1, dayOfMonth = 1)
        assertEquals(
            expected = expectedDate,
            actual = nextDate,
            message = "Data seguinte incorreta para o final de dezembro."
        )
    }

    @Test
    fun `DADO um iterator no último elemento de DateRange, QUANDO chamamos next, ENTÃO deve lançar NoSuchElementException`() {
        // DADO
        val range = DateRange(
            MyDate(year = 2016, month = 5, dayOfMonth = 5),
            MyDate(2016, 5, 5)
        )
        val iterator: Iterator<MyDate> = range.iterator()

        // Confirma que o iterator tem um próximo elemento
        assertTrue(iterator.hasNext())
        iterator.next() // Vai para o último elemento

        // QUANDO e ENTÃO
        assertFailsWith<NoSuchElementException> {
            iterator.next()
        }
    }

    @Test
    fun `DADO um mês inválido ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = 2016, month = 13, dayOfMonth = 5)
        }
    }

    @Test
    fun `DADO um dia inválido ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = 2016, month = 12, dayOfMonth = 32)
        }
    }

    @Test
    fun `DADO um valor negativo para o ano ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = -1, month = 5, dayOfMonth = 5)
        }
    }

    @Test
    fun `DADO um valor negativo para o mês ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = 2016, month = -5, dayOfMonth = 5)
        }
    }

    @Test
    fun `DADO um valor negativo para o dia ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = 2016, month = 5, dayOfMonth = -5)
        }
    }

    @Test
    fun `DADO o 30º de fevereiro em um ano não bissexto ao criar um MyDate, QUANDO tentamos instanciar, ENTÃO deve lançar IllegalArgumentException`() {
        // QUANDO e ENTÃO
        assertFailsWith<IllegalArgumentException> {
            MyDate(year = 2015, month = 2, dayOfMonth = 30)
        }
    }

    @Test
    fun `DADO um intervalo que atravessa vários anos, QUANDO iteramos, ENTÃO obtemos todas as datas no intervalo`() {
        // DADO
        val range = DateRange(
            MyDate(year = 2015, month = 12, dayOfMonth = 30),
            MyDate(year = 2016, month = 1, dayOfMonth = 2)
        )
        val expectedDates: List<MyDate> = listOf(
            MyDate(year = 2015, month = 12, dayOfMonth = 30),
            MyDate(year = 2015, month = 12, dayOfMonth = 31),
            MyDate(year = 2016, month = 1, dayOfMonth = 1),
            MyDate(year = 2016, month = 1, dayOfMonth = 2)
        )
        val actualDates: MutableList<MyDate> = mutableListOf()

        // QUANDO
        for (date: MyDate in range) {
            actualDates.add(date)
        }

        // ENTÃO
        assertEquals(
            expected = expectedDates,
            actual = actualDates,
            message = "A iteração em um intervalo que atravessa anos não retornou as datas esperadas."
        )
    }
}
