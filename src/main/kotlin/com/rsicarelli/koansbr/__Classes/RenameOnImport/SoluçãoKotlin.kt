/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

import java.util.Random as JRandom
import kotlin.random.Random as KRandom

fun useDifferentRandomClasses(): String {
    val kotlinRandom: Int = KRandom.nextInt(until = 2)
    val javaRandom: Int = JRandom().nextInt(/* bound = */ 2)

    return "Kotlin random: $kotlinRandom, Java random: $javaRandom."
}
