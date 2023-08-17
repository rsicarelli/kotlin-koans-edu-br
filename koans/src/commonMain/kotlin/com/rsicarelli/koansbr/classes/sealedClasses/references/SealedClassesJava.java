/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.sealedClasses.references;

public class SealedClassesJava {
    static int eval(Expr expr) {
        if (expr instanceof Num) {
            return ((Num) expr).value();
        } else if (expr instanceof Sum) {
            return eval(((Sum) expr).left()) + eval(((Sum) expr).right());
        } else {
            throw new IllegalArgumentException("Unknown Expr type");
        }
    }
}

sealed interface Expr permits Num, Sum {
}

record Num(int value) implements Expr {
}

record Sum(Expr left, Expr right) implements Expr {
}
