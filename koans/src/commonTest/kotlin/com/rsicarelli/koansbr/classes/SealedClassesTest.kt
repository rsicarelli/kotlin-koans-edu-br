/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.sealedClasses.Expr
import com.rsicarelli.koansbr.classes.sealedClasses.Num
import com.rsicarelli.koansbr.classes.sealedClasses.Sum
import com.rsicarelli.koansbr.classes.sealedClasses.eval
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SealedClassesTest {

    @Test
    fun `DADO uma expressão desconhecida QUANDO eu a avalio ENTÃO uma IllegalArgumentException é lançada`() {
        // DADO uma expressão desconhecida
        val unknownExpr = object : Expr {}

        // QUANDO tentamos avaliar a expressão desconhecida
        val exception: IllegalArgumentException = assertFailsWith<IllegalArgumentException> {
            eval(unknownExpr)
        }

        // ENTÃO uma IllegalArgumentException deve ser lançada com a mensagem correta
        assertEquals("Unknown expression", exception.message)
    }

    @Test
    fun `DADO um valor do tipo Num QUANDO eu avalio ENTÃO o resultado deve ser igual ao valor fornecido`() {
        // DADO um valor do tipo Num
        val num = Num(value = 2)

        // QUANDO avaliamos o valor
        val result: Int = eval(num)

        // ENTÃO o resultado deve ser igual ao valor fornecido
        assertEquals(
            expected = 2,
            actual = result
        )
    }

    @Test
    fun `DADO uma soma de dois números QUANDO eu avalio ENTÃO o resultado deve ser a soma dos dois números`() {
        // DADO uma soma de dois números
        val sum = Sum(
            left = Num(value = 2),
            right = Num(value = 1)
        )

        // QUANDO avaliamos a soma dos dois números
        val result = eval(sum)

        // ENTÃO o resultado deve ser a soma dos dois números
        assertEquals(
            expected = 3,
            actual = result
        )
    }

    @Test
    fun `DADO uma soma que inclui outra soma QUANDO eu avalio ENTÃO o resultado deve ser a soma das somas`() {
        // DADO uma soma que inclui outra soma
        val sumWithSum = Sum(
            left = Sum(
                left = Num(value = 2),
                right = Num(value = 1)
            ),
            right = Num(value = 3)
        )

        // QUANDO avaliamos a soma que inclui outra soma
        val result: Int = eval(sumWithSum)

        // ENTÃO o resultado deve ser a soma das somas
        assertEquals(
            expected = 6,
            actual = result
        )
    }
}
