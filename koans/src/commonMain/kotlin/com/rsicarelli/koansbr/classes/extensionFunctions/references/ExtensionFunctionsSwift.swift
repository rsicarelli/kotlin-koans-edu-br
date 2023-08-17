/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

struct Pair {
    let first: Int
    let second: Int
}

struct RationalNumber {
    let numerator: Int
    let denominator: Int
}

extension Int {
    func r() -> RationalNumber {
        return RationalNumber(numerator: self, denominator: 1)
    }
}

extension Pair {
    func r() -> RationalNumber {
        return RationalNumber(numerator: first, denominator: second)
    }
}

let result1 = 5.r()
let result2 = Pair(first: 7, second: 3).r()

print(result1)
print(result2)
