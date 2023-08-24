/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

function eval(expr) {
    if (expr instanceof Num) {
        return expr.value;
    } else if (expr instanceof Sum) {
        return eval(expr.left) + eval(expr.right);
    } else {
        throw new Error('Unknown expression');
    }
}

class Expr {
}

class Num extends Expr {
    constructor(value) {
        super();
        this.value = value;
    }
}

class Sum extends Expr {
    constructor(left, right) {
        super();
        this.left = left;
        this.right = right;
    }
}
