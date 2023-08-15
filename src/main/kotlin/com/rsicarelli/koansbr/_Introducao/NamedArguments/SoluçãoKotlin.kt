/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

fun joinOptions(options: List<String>): String =
    options.joinToString(
        prefix = "[",
        postfix = "]"
    )
