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
}
