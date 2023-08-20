/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.sealedClasses.Expr
import com.rsicarelli.koansbr.classes.sealedClasses.Num
import com.rsicarelli.koansbr.classes.sealedClasses.Sum
import com.rsicarelli.koansbr.classes.sealedClasses.eval
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class SealedClassesTest {

    @Test
    fun `DADO um valor do tipo Num, QUANDO se avalia, ENTÃO o resultado deve ser igual ao valor fornecido`() {
        // DADO
        val num = Num(value = 2)

        // QUANDO
        val result: Int = eval(num)

        // ENTÃO
        assertEquals(
            expected = 2,
            actual = result
        )
    }

    @Test
    fun `DADO uma soma de dois números, QUANDO se avalia, ENTÃO o resultado deve ser a soma dos dois números`() {
        // DADO
        val sum = Sum(
            left = Num(value = 2),
            right = Num(value = 1)
        )

        // QUANDO
        val result = eval(sum)

        // ENTÃO
        assertEquals(
            expected = 3,
            actual = result
        )
    }

    @Test
    fun `DADO uma soma que inclui outra soma, QUANDO se avalia, ENTÃO o resultado deve ser a soma das somas`() {
        // DADO
        val sumWithSum = Sum(
            left = Sum(
                left = Num(value = 2),
                right = Num(value = 1)
            ),
            right = Num(value = 3)
        )

        // QUANDO
        val result: Int = eval(sumWithSum)

        // ENTÃO
        assertEquals(
            expected = 6,
            actual = result
        )
    }

    @Test
    fun `DADO todas as possíveis variações de Expr, QUANDO cada uma é avaliada, ENTÃO não ocorre exceção de implementação faltante`() {
        val allPossibleExprTypes: List<KClass<out Expr>> = Expr::class.sealedSubclasses

        allPossibleExprTypes.forEach { exprType ->
            runCatching {
                val instance: Expr = when (exprType) {
                    Num::class -> Num(value = 1)
                    Sum::class -> Sum(left = Num(value = 1), right = Num(value = 2))
                    else -> fail("Falta uma implementação para: ${exprType.simpleName}")
                }

                eval(instance) // Testa se a avaliação é possível.
            }.onFailure {
                fail("Falta uma implementação para: ${exprType.simpleName}")
            }
        }
    }
}
