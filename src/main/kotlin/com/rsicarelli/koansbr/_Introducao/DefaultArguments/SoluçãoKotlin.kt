/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo(): List<String> = listOf(
    foo(name = "a"),
    foo(name = "b", number = 1),
    foo(name = "c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)
