
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.smartCasts.references;

public class SmartCastsJava {
    public int eval(ExprJava expr) {
        if (expr instanceof NumJava) {
            return ((NumJava) expr).value;
        } else if (expr instanceof SumJava) {
            return eval(((SumJava) expr).left) + eval(((SumJava) expr).right);
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
    }

}

interface ExprJava {
}

class NumJava implements ExprJava {
    final int value;

    NumJava(int value) {
        this.value = value;
    }
}

class SumJava implements ExprJava {
    final ExprJava left, right;

    SumJava(ExprJava left, ExprJava right) {
        this.left = left;
        this.right = right;
    }
}
