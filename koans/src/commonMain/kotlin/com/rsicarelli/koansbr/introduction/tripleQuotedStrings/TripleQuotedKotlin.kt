/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
package com.rsicarelli.koansbr.introduction.tripleQuotedStrings

const val question: String = "life, the universe, and everything"
const val answer: Int = 42

val tripleQuotedString: String =
    """
    #question = "$question"
    #answer = $answer
    """.trimMargin(
        marginPrefix = "#"
    )
