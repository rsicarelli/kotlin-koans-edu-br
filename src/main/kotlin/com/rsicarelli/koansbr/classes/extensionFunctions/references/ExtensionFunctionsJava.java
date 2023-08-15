/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.extensionFunctions.references;

public class ExtensionFunctionsJava {

    public static void main(String[] args) {
        RationalNumberJava rn = RationalUtils.r(2, 3);
        System.out.println(rn);
    }
}

class RationalUtils {
    public static RationalNumberJava r(int n) {
        return new RationalNumberJava(n, 1);
    }

    public static RationalNumberJava r(int numerator, int denominator) {
        return new RationalNumberJava(numerator, denominator);
    }
}

class RationalNumberJava {
    private final int numerator;
    private final int denominator;

    public RationalNumberJava(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}


