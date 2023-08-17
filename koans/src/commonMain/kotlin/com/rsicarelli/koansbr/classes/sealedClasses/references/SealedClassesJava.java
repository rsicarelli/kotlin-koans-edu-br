/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.sealedClasses.references;

/**
 * Classe principal para demonstrar o uso de classes seladas.
 */
public class SealedClassesJava {

    /**
     * Avalia a expressão fornecida.
     *
     * @param expr A expressão a ser avaliada.
     * @return O valor da expressão.
     * @throws IllegalArgumentException Se o tipo de expressão for desconhecido.
     */
    static int eval(Expr expr) {
        if (expr instanceof Num) {
            return ((Num) expr).value();
        } else if (expr instanceof Sum) {
            return eval(((Sum) expr).left()) + eval(((Sum) expr).right());
        } else {
            throw new IllegalArgumentException("Tipo de expressão desconhecido");
        }
    }
}

sealed interface Expr permits Num, Sum {
}

record Num(int value) implements Expr {
}

record Sum(Expr left, Expr right) implements Expr {
}
