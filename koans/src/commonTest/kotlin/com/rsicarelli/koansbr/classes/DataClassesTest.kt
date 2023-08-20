/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.dataClasses.Person
import com.rsicarelli.koansbr.classes.dataClasses.comparePeople
import com.rsicarelli.koansbr.classes.dataClasses.getPeople
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DataClassesTest {

    @Test
    fun `QUANDO a função getPeople é chamada, ENTÃO ela deve retornar uma lista contendo Alice e Bob`() {
        // QUANDO
        val pessoas: List<Person> = getPeople()

        // ENTÃO
        val pessoasEsperadas: List<Person> = listOf(
            Person(name = "Alice", age = 29),
            Person(name = "Bob", age = 31)
        )
        assertEquals(
            expected = pessoasEsperadas,
            actual = pessoas,
            message = "A lista $pessoas é diferente da esperada $pessoasEsperadas"
        )
    }

    @Test
    fun `DADO uma pessoa, QUANDO a função toString é chamada, ENTÃO deve seguir o formato esperado`() {
        // DADO
        val pessoa = Person(name = "Raquel", age = 30)

        // QUANDO
        val resultado: String = pessoa.toString()

        // ENTÃO
        val esperado = "Person(name=Raquel, age=30)"
        assertEquals(
            expected = esperado,
            actual = resultado,
            message = "A representação de toString da classe Person está diferente do esperado $esperado."
        )
    }

    @Test
    fun `QUANDO a função comparePeople é chamada, ENTÃO ela deve retornar verdadeiro`() {
        // QUANDO
        val saoIguais: Boolean = comparePeople()

        // ENTÃO
        assertTrue(
            actual = saoIguais,
            message = "'comparePeople' deveria retornar verdadeiro"
        )
    }

    @Test
    fun `DADO duas pessoas iguais, QUANDO hashCode é chamada, ENTÃO deve retornar o mesmo valor para ambos`() {
        // DADO
        val pessoa1 = Person(name = "Luciana", age = 30)
        val pessoa2 = Person(name = "Luciana", age = 30)

        // QUANDO
        val hashCode1: Int = pessoa1.hashCode()
        val hashCode2: Int = pessoa2.hashCode()

        // ENTÃO
        assertEquals(
            expected = hashCode1,
            actual = hashCode2,
            message = "Os hashCodes de duas pessoas iguais devem ser o mesmo."
        )
    }
}
