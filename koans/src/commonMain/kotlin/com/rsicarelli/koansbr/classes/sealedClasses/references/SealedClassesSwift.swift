/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

indirect enum Expr {
    case num(value: Int)
    case sum(left: Expr, right: Expr)
}

func eval(_ expr: Expr) -> Int {
    switch expr {
    case let .num(value):
        return value
    case let .sum(left, right):
        return eval(left) + eval(right)
    }
}
