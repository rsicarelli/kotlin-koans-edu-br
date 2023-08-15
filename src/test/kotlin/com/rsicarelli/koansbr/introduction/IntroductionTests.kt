/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

@file:Suppress("NonAsciiCharacters")

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.defaultArguments.foo
import com.rsicarelli.koansbr.introduction.defaultArguments.useFoo
import com.rsicarelli.koansbr.introduction.helloWorld.start
import com.rsicarelli.koansbr.introduction.lambdas.containsEven
import com.rsicarelli.koansbr.introduction.namedArguments.joinOptions
import com.rsicarelli.koansbr.introduction.nothingType.checkAge
import com.rsicarelli.koansbr.introduction.nullableTypes.Client
import com.rsicarelli.koansbr.introduction.nullableTypes.Mailer
import com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo
import com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient
import com.rsicarelli.koansbr.introduction.stringTemplates.getPattern
import com.rsicarelli.koansbr.introduction.tripleQuotedStrings.tripleQuotedString
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class IntroductionTests {

    @Nested
    inner class HelloWorldTests {

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

    @Nested
    inner class NamedArgumentsTests {

        @Test
        fun `DADO uma lista de opções, QUANDO o método joinOptions é chamado, ENTÃO ele deve retornar as opções em uma String formatada corretamente`() {
            // DADO
            val options: List<String> = listOf("opção1", "opção2", "opção3")

            // QUANDO
            val resultado: String = joinOptions(options)

            // ENTÃO
            assertEquals(
                actual = resultado,
                expected = "[opção1, opção2, opção3]",
            )
        }

        @Test
        fun `DADO uma lista vazia, QUANDO o método joinOptions é chamado, ENTÃO ele deve retornar uma String com brackets vazios`() {
            // DADO
            val options: List<String> = emptyList()

            // QUANDO
            val resultado: String = joinOptions(options)

            // ENTÃO
            assertEquals(
                actual = resultado,
                expected = "[]",
            )
        }
    }

    @Nested
    inner class DefaultArgumentsTests {

        @Test
        fun `DADO um nome e um número, QUANDO o método foo é chamado, ENTÃO ele deve retornar a concatenação do nome e número`() {
            // DADO
            val name = "test"
            val number = 123

            // QUANDO
            val resultado: String = foo(
                name = name,
                number = number
            )

            // ENTÃO
            val expected = "test123"
            assertEquals(
                expected = expected,
                actual = resultado,
                message = "A concatenação do nome e número: $resultado não segue o esperado $expected"
            )
        }

        @Test
        fun `DADO um nome e um número, com a opção de tornar maiúsculo, QUANDO o método foo é chamado, ENTÃO ele deve retornar a concatenação do nome (em maiúsculas) e número`() {
            // DADO
            val name = "test"
            val number = 123

            // QUANDO
            val resultado: String = foo(
                name = name,
                number = number,
                toUpperCase = true
            )

            // ENTÃO
            val expected = "TEST123"
            assertEquals(
                expected = expected,
                actual = resultado,
                message = "A concatenação do nome (em maiúsculo) e número: $resultado não segue o esperado $expected"
            )
        }

        @Test
        fun `QUANDO o método useFoo é chamado, ENTÃO ele deve retornar uma lista com strings formatadas corretamente`() {
            // QUANDO
            val resultado: List<String> = useFoo()

            // ENTÃO
            val expectedResult: List<String> = listOf("a42", "b1", "C42", "D2")
            assertEquals(
                expected = expectedResult,
                actual = resultado,
                message = "A lista de strings retornada ${resultado.joinToString(",") { it }} não segue o esperado: $expectedResult"
            )
        }
    }

    @Nested
    inner class TripleQuotedTests {

        @Test
        fun `DADO pergunta e resposta, QUANDO tripleQuotedString for executado, ENTÃO deve retornar uma string correta`() {
            // DADO
            val outputEsperado: String = """
            question = "life, the universe, and everything"
            com.rsicarelli.koansbr.introduction.tripleQuotedStrings.answer = 42
        """.trimIndent()

            // QUANDO
            val output: String = tripleQuotedString

            // ENTÃO
            assertEquals(
                actual = output,
                expected = outputEsperado,
            )
        }
    }

    @Nested
    inner class StringTemplateTests {

        @ParameterizedTest
        @CsvSource(
            "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
            "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
        )
        fun `DADO um mês, QUANDO getPattern for chamado, ENTÃO ele deve conter o mês passado no meio do resultado`(mes: String) {
            // QUANDO
            val resultado: String = getPattern()

            // ENTÃO
            assert(value = resultado.contains(mes)) {
                "O padrão não contém o mês esperado. Padrão: $resultado, Mes Esperado: $mes"
            }
        }

        @Test
        fun `DADO a string 11 MAR 1952, QUANDO combinada com o padrão, ENTÃO deve corresponder`() {
            // DADO
            val entrada = "11 MAR 1952"

            // QUANDO
            val corresponde: Boolean = entrada.matches(getPattern().toRegex())

            // ENTÃO
            assertTrue(
                actual = corresponde,
                message = "O padrão deve corresponder a $entrada"
            )
        }

        @Test
        fun `DADO a string 24 AUG 1957, QUANDO combinada com o padrão, ENTÃO deve corresponder`() {
            // DADO
            val entrada = "24 AUG 1957"

            // QUANDO
            val corresponde: Boolean = entrada.matches(getPattern().toRegex())

            // ENTÃO
            assertTrue(
                actual = corresponde,
                message = "O padrão deve corresponder a $entrada"
            )
        }

        @Test
        fun `DADO a string 24 RRR 1957, QUANDO combinada com o padrão, ENTÃO não deve corresponder`() {
            // DADO
            val entrada = "24 RRR 1957"

            // QUANDO
            val corresponde: Boolean = entrada.matches(getPattern().toRegex())

            // ENTÃO
            assertFalse(
                actual = corresponde,
                message = "O padrão não deve corresponder a $entrada"
            )
        }
    }

    @Nested
    inner class NullTypeTests {

        /**
         * FakeMailer é uma classe "fake" que implementa a interface com.rsicarelli.koansbr.introduction.nullableTypes.Mailer.
         *
         * Um "fake" em testes unitários é uma implementação funcional de uma classe ou interface
         * usada para testar comportamentos na unidade de código sob teste. Em contraste com
         * mocks, fakes têm comportamentos funcionais e não precisam ser configurados para responder
         * de determinada maneira. Eles são úteis quando o comportamento da classe real é complexo
         * ou não desejado em um teste de unidade (por exemplo, enviar um e-mail de verdade).
         *
         * Esta classe [FakeMailer] é usada para testar se a função [sendMessageToClient] está chamando
         * corretamente a função [Mailer.sendMessage] na interface com.rsicarelli.koansbr.introduction.nullableTypes.Mailer. Ela guarda a última mensagem e
         * o destinatário em que a função [Mailer.sendMessage] foi chamada, permitindo que o teste verifique
         * se as chamadas corretas foram feitas.
         */
        inner class FakeMailer : Mailer {

            var messageSent: String? = null
            var receiver: String? = null

            override fun sendMessage(email: String, message: String) {
                this.receiver = email
                this.messageSent = message
            }
        }

        @Test
        fun `DADO um cliente com email e uma mensagem, QUANDO sendMessageToClient é chamado, ENTÃO deve enviar a mensagem`() {
            // DADO
            val client = Client(
                personalInfo = PersonalInfo(
                    email = "cliente@exemplo.com"
                )
            )
            val message = "Olá, cliente!"
            val fakeMailer = FakeMailer()

            // QUANDO
            sendMessageToClient(
                client = client,
                message = message,
                mailer = fakeMailer
            )

            // ENTÃO
            assertEquals(
                expected = "cliente@exemplo.com",
                actual = fakeMailer.receiver
            )
            assertEquals(
                expected = message,
                actual = fakeMailer.messageSent
            )
        }

        @Test
        fun `DADO um cliente sem email e uma mensagem, QUANDO sendMessageToClient é chamado, ENTÃO não deve enviar a mensagem`() {
            // DADO
            val client = Client(
                personalInfo = PersonalInfo(
                    email = null
                )
            )
            val message = "Olá, cliente!"
            val fakeMailer = FakeMailer()

            // QUANDO
            sendMessageToClient(
                client = client,
                message = message,
                mailer = fakeMailer
            )

            // ENTÃO
            assertNull(fakeMailer.receiver)
            assertNull(fakeMailer.messageSent)
        }

        @Test
        fun `DADO um cliente com email e sem mensagem, QUANDO sendMessageToClient é chamado, ENTÃO não deve enviar a mensagem`() {
            // DADO
            val client = Client(
                personalInfo = PersonalInfo(
                    email = "cliente@exemplo.com"
                )
            )
            val fakeMailer = FakeMailer()

            // QUANDO
            sendMessageToClient(
                client = client,
                message = null,
                mailer = fakeMailer
            )

            // ENTÃO
            assertNull(fakeMailer.receiver)
            assertNull(fakeMailer.messageSent)
        }

        @Test
        fun `DADO que não há cliente e nem mensagem, QUANDO sendMessageToClient é chamado, ENTÃO não deve enviar a mensagem`() {
            // DADO
            val fakeMailer = FakeMailer()

            // QUANDO
            sendMessageToClient(
                client = null,
                message = null,
                mailer = fakeMailer
            );

            // ENTÃO
            assertNull(fakeMailer.receiver)
            assertNull(fakeMailer.messageSent)
        }
    }

    @Nested
    inner class NothingTypeTests {

        @Test
        fun `DADO idade nula, QUANDO checkAge é chamado, ENTÃO deve lançar IllegalArgumentException`() {
            // DADO
            val idade: Int? = null

            // QUANDO / ENTÃO
            val exception: IllegalArgumentException = assertThrows<IllegalArgumentException> {
                checkAge(idade)
            }
            assertEquals("Wrong age: null", exception.message)
        }

        @Test
        fun `DADO idade negativa, QUANDO checkAge eh chamado, ENTÃO deve lançar IllegalArgumentException`() {
            // DADO
            val idade = -1

            // QUANDO / ENTÃO
            val exception = assertThrows<IllegalArgumentException> {
                checkAge(idade)
            }
            assertEquals("Wrong age: $idade", exception.message)
        }

        @Test
        fun `DADO idade muito alta, QUANDO checkAge eh chamado, ENTÃO deve lançar IllegalArgumentException`() {
            // DADO
            val idade = 151

            // QUANDO / ENTÃO
            val exception = assertThrows<IllegalArgumentException> {
                checkAge(idade)
            }
            assertEquals("Wrong age: $idade", exception.message)
        }

        @Test
        fun `DADO idade aceitável, QUANDO checkAge eh chamado, ENTÃO a mensagem correta deve ser impressa`() {
            // DADO
            val idade = 25
            val baos = ByteArrayOutputStream()
            val oldOut = System.out
            System.setOut(PrintStream(baos))

            // QUANDO
            checkAge(idade)

            // ENTÃO
            assertEquals("Congrats! Next year you'll be ${idade + 1}.\n", baos.toString())

            // Restaurar o output do console
            System.setOut(oldOut)
        }

    }

    @Nested
    inner class LambdaTests {

        @Test
        fun contains() {
            assertTrue(
                actual = containsEven(
                    collection = listOf(1, 2, 3, 126, 555)
                ),
                message = "The result should be true if the collection contains an even number"
            )
        }

        @Test
        fun notContains() {
            assertFalse(
                actual = containsEven(
                    collection = listOf(43, 33)
                ),
                message = "The result should be false if the collection doesn't contain an even number"
            )
        }
    }
}
