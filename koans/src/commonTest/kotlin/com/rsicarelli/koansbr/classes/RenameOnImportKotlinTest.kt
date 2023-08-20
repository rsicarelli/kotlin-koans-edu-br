/*
 * SPDX-License-Identifier: MIT

 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.renameOnImport.useDifferentRandomClasses
import kotlin.test.Test
import kotlin.test.assertTrue

class RenameOnImportKotlinTest {

    @Test
    fun `DADO que invocamos a função useDifferentRandomClasses, QUANDO recebemos o resultado da funcao, ENTÃO deve conter numeros aleatórios 0 ou 1`() {
        //DADO, QUANDO
        val result: String = useDifferentRandomClasses()

        //ENTÃO
        assertTrue(
            actual = setOf('0', '1').any { it in result },
            message = "A string retornada deve conter números aleatórios 0 ou 1\n$result"
        )
    }
}

