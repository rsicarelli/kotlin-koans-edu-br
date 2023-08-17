/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

protocol Expr {}

struct Num: Expr {
    let value: Int
}

struct Sum: Expr {
    let left: Expr
    let right: Expr
}

func eval(_ expr: Expr) -> Int {
    switch expr {
    case let n as Num:
        return n.value
    case let s as Sum:
        return eval(s.left) + eval(s.right)
    default:
        fatalError("Unknown Expr type")
    }
}
