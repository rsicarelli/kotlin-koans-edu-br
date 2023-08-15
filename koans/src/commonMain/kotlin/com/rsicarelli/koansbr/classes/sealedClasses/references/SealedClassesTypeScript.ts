/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

abstract class Expr {
}

class Num extends Expr {
    constructor(public value: number) {
        super();
    }
}

class Sum extends Expr {
    constructor(public left: Expr, public right: Expr) {
        super();
    }
}

function eval(expr: Expr): number {
    if (expr instanceof Num) {
        return expr.value;
    } else if (expr instanceof Sum) {
        return eval(expr.left) + eval(expr.right);
    }
    throw new Error("Unknown Expr type");
}
