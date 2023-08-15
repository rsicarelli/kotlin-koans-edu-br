/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

@file:Suppress("NonAsciiCharacters")

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.dataClasses.Person
import com.rsicarelli.koansbr.classes.dataClasses.getPeople
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `ob`() {
        // QUANDO
        val pessoas: List<Person> = getPeople()

        // ENTÃO
        val pessoasEsperadas: List<Person> = listOf(
            Person(name = "Alice", age = 50),
            Person(name = "Bob", age = 18)
        )
        assertEquals(
            expected = pessoasEsperadas,
            actual = pessoas,
            message = "A lista $pessoas é diferente da esperada $pessoasEsperadas"
        )
    }
//    @Nested
//    inner class DataClasses {
//
//        @Test
//        fun `QUANDO a função getPeople é chamada, ENTÃO ela deve retornar uma lista contendo Alice e Bob`() {
//            // QUANDO
//            val pessoas: List<Person> = getPeople()
//
//            // ENTÃO
//            val pessoasEsperadas: List<Person> = listOf(
//                Person(name = "Alice", age = 50),
//                Person(name = "Bob", age = 18)
//            )
//            assertEquals(
//                expected = pessoasEsperadas,
//                actual = pessoas,
//                message = "A lista $pessoas é diferente da esperada $pessoasEsperadas"
//            )
//        }
//
//        @Test
//        fun `DADO uma pessoa, QUANDO o método toString é chamado, ENTÃO ele deve seguir o formato esperado`() {
//            // DADO
//            val pessoa = Person(name = "Raquel", age = 30)
//
//            // QUANDO
//            val resultado: String = pessoa.toString()
//
//            // ENTÃO
//            val esperado = "Person(name=Raquel, age=30)"
//            assertEquals(
//                expected = esperado,
//                actual = resultado,
//                message = "A representação de toString da classe Person está diferente do esperado $esperado."
//            )
//        }
//
//        @Test
//        fun `QUANDO a função comparePeople é chamada, ENTÃO ela deve retornar verdadeiro`() {
//            // QUANDO
//            val saoIguais: Boolean = comparePeople()
//
//            // ENTÃO
//            assertTrue(
//                actual = saoIguais,
//                message = "'comparePeople' deveria retornar verdadeiro"
//            )
//        }
//
//        @Test
//        fun `DADO duas pessoas iguais, QUANDO hashCode é chamado, ENTÃO ele deve retornar o mesmo valor para ambos`() {
//            // DADO
//            val pessoa1 = Person(name = "Luciana", age = 30)
//            val pessoa2 = Person(name = "Luciana", age = 30)
//
//            // QUANDO
//            val hashCode1: Int = pessoa1.hashCode()
//            val hashCode2: Int = pessoa2.hashCode()
//
//            // ENTÃO
//            assertEquals(
//                expected = hashCode1,
//                actual = hashCode2,
//                message = "Os hashCodes de duas pessoas iguais devem ser o mesmo."
//            )
//        }
//
////        @ParameterizedTest
////        @ValueSource(strings = ["Samantha", "Joana", "Júlio"])
////        fun `DADO uma pessoa, QUANDO copy for chamado, ENTÃO ele deve retornar uma cópia igual mas não o mesmo objeto`(nome: String) {
////            // DADO
////            val person = Person(
////                name = nome,
////                age = Random.nextInt()
////            )
////
////            // QUANDO
////            val copy = person.copy()
////
////            // THEN
////            assertEquals(
////                expected = person,
////                actual = copy,
////                message = "A cópia deve ser igual ao original"
////            )
////            assertNotSame(
////                illegal = person,
////                actual = copy,
////                message = "A cópia deve ser um objeto diferente do inicial"
////            )
////        }
//
//    }
//
//    @Test
//    fun testIntExtension() {
//        DefaultAsserter.assertEquals("Rational number creation error: ", RationalNumber(4, 1), 4.r())
//    }
//
//    @Test
//    fun testPairExtension() {
//        DefaultAsserter.assertEquals("Rational number creation error: ", RationalNumber(2, 3), Pair(2, 3).r())
//    }
//
//    @Test
//    fun testRandom() {
//        val string = useDifferentRandomClasses()
//        DefaultAsserter.assertTrue(
//            "The string should contain random numbers 0 or 1\n$string",
//            setOf('0', '1').any { it in string })
//    }
//
//    @Test
//    fun testNum() {
//        DefaultAsserter.assertEquals("'eval' on Num(2) works incorrectly\n", 2, eval(Num(2)))
//    }
//
//    @Test
//    fun testSum() {
//        DefaultAsserter.assertEquals("'eval' on Sum(Num(2), Num(1)) works incorrectly\n", 3, eval(Sum(Num(2), Num(1))))
//    }

//    @Test
//    fun testRecursion() {
//        DefaultAsserter.assertEquals(
//            "'eval' on Sum(Sum(Num(1), Num(2)), Num(3)) works incorrectly\n",
//            6,
//            eval(Sum(Sum(Num(1), Num(2)), Num(3)))
//        )
//    }

}
