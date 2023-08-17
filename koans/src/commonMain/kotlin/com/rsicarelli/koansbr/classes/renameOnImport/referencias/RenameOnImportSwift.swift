/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class JavaRandom {
    func nextInt(value: Int) -> Int {
        return value
    }
}

class KotlinRandom {
    func nextInt(value: Int) -> Int {
        return value
    }
}

func useDifferentRandomClasses() -> String {
    return "Kotlin random: \(KotlinRandom().nextInt(value: 2)) Java random: \(JavaRandom().nextInt(value: 2))."
}

print(useDifferentRandomClasses())
