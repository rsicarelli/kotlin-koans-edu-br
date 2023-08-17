/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.introduction.lambdas

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }
