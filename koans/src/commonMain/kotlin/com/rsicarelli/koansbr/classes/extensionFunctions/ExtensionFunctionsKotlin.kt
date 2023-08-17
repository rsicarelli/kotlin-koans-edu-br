/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.classes.extensionFunctions

fun Int.r(): RationalNumber =
    RationalNumber(
        numerator = this,
        denominator = 1
    )

fun Pair<Int, Int>.r(): RationalNumber =
    RationalNumber(
        numerator = first,
        denominator = second
    )

data class RationalNumber(
    val numerator: Int,
    val denominator: Int,
)
