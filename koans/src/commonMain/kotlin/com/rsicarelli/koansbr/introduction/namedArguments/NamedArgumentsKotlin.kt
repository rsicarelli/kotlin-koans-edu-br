/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.introduction.namedArguments

fun joinOptions(options: List<String>): String =
    options.joinToString(
        prefix = "[",
        postfix = "]"
    )
