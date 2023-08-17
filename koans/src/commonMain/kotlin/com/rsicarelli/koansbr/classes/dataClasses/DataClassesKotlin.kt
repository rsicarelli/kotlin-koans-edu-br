/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.classes.dataClasses

data class Person(
    val name: String,
    val age: Int,
)

fun getPeople(): List<Person> =
    listOf(
        Person(name = "Alice", age = 29),
        Person(name = "Bob", age = 31)
    )

fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  // true
}
