/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }
