/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

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
        return RationalNumber(numerator: self.first, denominator: self.second)
    }
}
