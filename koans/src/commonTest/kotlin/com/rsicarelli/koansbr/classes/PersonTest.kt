/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

@file:Suppress("NonAsciiCharacters")

package com.rsicarelli.koansbr.classes

import com.rsicarelli.koansbr.classes.renameOnImport.useDifferentRandomClasses
import com.rsicarelli.koansbr.classes.smartCasts.Num
import com.rsicarelli.koansbr.classes.smartCasts.Sum
import com.rsicarelli.koansbr.classes.smartCasts.eval
import kotlin.test.DefaultAsserter
import kotlin.test.Test

class PersonTest {

    @Test
    fun testRandom() {
        val string = useDifferentRandomClasses()
        DefaultAsserter.assertTrue(
            "The string should contain random numbers 0 or 1\n$string",
            setOf('0', '1').any { it in string })
    }

    @Test
    fun testRecursion() {
        DefaultAsserter.assertEquals(
            "'eval' on Sum(Sum(Num(1), Num(2)), Num(3)) works incorrectly\n",
            6,
            eval(Sum(Sum(Num(1), Num(2)), Num(3)))
        )
    }

}
