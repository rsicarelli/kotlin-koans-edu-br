/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.sealedClasses.references;

public class SealedClassesJava {
    static int eval(Expr expr) {
        if (expr instanceof Num) {
            return ((Num) expr).value;
        } else if (expr instanceof Sum) {
            return eval(((Sum) expr).left) + eval(((Sum) expr).right);
        }
        throw new IllegalArgumentException("Unknown Expr type");
    }
}

abstract class Expr {
}

/**
 * O Java não possui suporte direto para "sealed classes", mas pode-se usar um modificador final em
 * classes para impedir a extensão
 */
final class Num extends Expr {
    public final int value;

    public Num(int value) {
        this.value = value;
    }
}

final class Sum extends Expr {
    public final Expr left;
    public final Expr right;

    public Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}



