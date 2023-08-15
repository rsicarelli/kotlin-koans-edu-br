/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const val question: String = "life, the universe, and everything"
const val answer: Int = 42

val tripleQuotedString: String =
    """
    #question = "$question"
    #answer = $answer
    """.trimMargin(
        marginPrefix = "#"
    )
