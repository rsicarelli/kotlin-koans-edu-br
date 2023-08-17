/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction

import com.rsicarelli.koansbr.introduction.nullableTypes.Client
import com.rsicarelli.koansbr.introduction.nullableTypes.Mailer
import com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo
import com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class NullTypeTests {

    /**
     * FakeMailer é uma classe "fake" que implementa a interface [Mailer].
     *
     * Um "fake" em testes unitários é uma implementação funcional de uma classe ou interface
     * usada para testar comportamentos na unidade de código sob teste. Em contraste com
     * mocks, fakes têm comportamentos funcionais e não precisam ser configurados para responder
     * de determinada maneira. Eles são úteis quando o comportamento da classe real é complexo
     * ou não desejado em um teste de unidade (por exemplo, enviar um e-mail de verdade).
     *
     * Esta classe [FakeMailer] é usada para testar se a função [sendMessageToClient] está chamando
     * corretamente a função [Mailer.sendMessage]. Ela guarda a última mensagem e
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
        )

        // ENTÃO
        assertNull(fakeMailer.receiver)
        assertNull(fakeMailer.messageSent)
    }
}
