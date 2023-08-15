/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

func foo(_ name: String, number: Int = 42, toUpperCase: Bool = false) -> String {
    return (toUpperCase ? name.uppercased() : name) + String(number)
}

func useFoo() -> [String] {
    return [
        foo("a"),
        foo("b", number: 1),
        foo("c", toUpperCase: true),
        foo("d", number: 2, toUpperCase: true)
    ]
}
