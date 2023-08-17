/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

struct Person: Equatable {
    let name: String
    let age: Int
}

func getPeople() -> [Person] {
    return [
        Person(name: "Alice", age: 29),
        Person(name: "Bob", age: 31)
    ]
}

func comparePeople() -> Bool {
    let p1 = Person(name: "Alice", age: 29)
    let p2 = Person(name: "Alice", age: 29)
    return p1 == p2  // true
}

let people = getPeople()
print(people)
print(comparePeople())

