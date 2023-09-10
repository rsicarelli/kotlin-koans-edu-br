package com.rsicarelli.koansbr.conventions

import com.rsicarelli.koansbr.conventions.comparison.MyDate
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ComparisonKotlinTest {

    @Test
    fun `DADO duas datas, QUANDO a primeira data é anterior à segunda, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(year = 2014, month = 5, dayOfMonth = 10)
        val segundaData = MyDate(year = 2014, month = 7, dayOfMonth = 11)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser anterior à $segundaData")
    }

    @Test
    fun `DADO duas datas, QUANDO a primeira data é posterior à segunda, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(year = 2014, month = 10, dayOfMonth = 20)
        val segundaData = MyDate(year = 2014, month = 7, dayOfMonth = 11)

        // QUANDO
        val resultado = primeiraData > segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser posterior à $segundaData")
    }

    @Test
    fun `DADO duas datas iguais, QUANDO comparadas, ENTÃO devem ser consideradas iguais`() {
        // DADO
        val primeiraData = MyDate(year = 2014, month = 7, dayOfMonth = 11)
        val segundaData = MyDate(year = 2014, month = 7, dayOfMonth = 11)

        // QUANDO
        val resultado = primeiraData == segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser igual à $segundaData")
    }

    @Test
    fun `DADO duas datas no mesmo ano e mês, QUANDO a primeira data é anterior à segunda, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(2014, 7, 10)
        val segundaData = MyDate(2014, 7, 15)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser anterior à $segundaData")
    }

    @Test
    fun `DADO duas datas no mesmo ano, QUANDO a primeira data é anterior à segunda por meses, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(2014, 5, 15)
        val segundaData = MyDate(2014, 10, 15)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser anterior à $segundaData por meses")
    }

    @Test
    fun `DADO duas datas em anos diferentes, QUANDO a primeira data é anterior à segunda, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(2013, 12, 31)
        val segundaData = MyDate(2014, 1, 1)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData deve ser anterior à $segundaData por anos")
    }

    @Test
    fun `DADO duas datas no mesmo ano e mês, QUANDO são consideradas iguais, mas o dia da primeira é posterior ao da segunda, ENTÃO deve retornar falso`() {
        // DADO
        val primeiraData = MyDate(2014, 7, 15)
        val segundaData = MyDate(2014, 7, 10)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertFalse(resultado, "A data $primeiraData não deve ser considerada anterior à $segundaData")
    }

    @Test
    fun `DADO duas datas com mesmo dia e mês, QUANDO o ano da primeira é anterior ao da segunda, ENTÃO deve retornar verdadeiro`() {
        // DADO
        val primeiraData = MyDate(2013, 12, 31)
        val segundaData = MyDate(2014, 12, 31)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertTrue(resultado, "A data $primeiraData com o mesmo dia e mês deve ser anterior à $segundaData devido ao ano")
    }

    @Test
    fun `DADO duas datas com mesmo dia e mês, QUANDO o ano da primeira é posterior ao da segunda, ENTÃO deve retornar falso para anterioridade`() {
        // DADO
        val primeiraData = MyDate(2015, 12, 31)
        val segundaData = MyDate(2014, 12, 31)

        // QUANDO
        val resultado = primeiraData < segundaData

        // ENTÃO
        assertFalse(resultado, "A data $primeiraData com o mesmo dia e mês não deve ser anterior à $segundaData devido ao ano")
    }

    @Test
    fun `DADO duas datas completamente idênticas, QUANDO comparadas com compareTo, ENTÃO deve retornar 0`() {
        // DADO
        val primeiraData = MyDate(2014, 12, 31)
        val segundaData = MyDate(2014, 12, 31)

        // QUANDO
        val resultado = primeiraData.compareTo(segundaData)

        // ENTÃO
        assertTrue(resultado == 0, "A data $primeiraData deve ser idêntica à $segundaData quando usamos compareTo")
    }
}
