/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// Swift suporta default arguments.

func foo(name: String, number: Int = 42, toUpperCase: Bool = false) -> String {
    return (toUpperCase ? name.uppercased() : name) + String(number)
}

func useFoo() -> [String] {
    return [
        foo(name: "a"),
        foo(name: "b", number: 1),
        foo(name: "c", toUpperCase: true),
        foo(name: "d", number: 2, toUpperCase: true)
    ]
}

let result = useFoo()
print(result)
