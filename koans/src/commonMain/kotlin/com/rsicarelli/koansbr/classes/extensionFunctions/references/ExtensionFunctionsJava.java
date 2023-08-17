/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.extensionFunctions.references;

public class ExtensionFunctionsJava {
    public static void main(String[] args) {
        RationalNumber result1 = ExtensionFunctions.r(5);
        RationalNumber result2 = ExtensionFunctions.r(new Pair<>(7, 3));

        System.out.println(result1);
        System.out.println(result2);
    }
}

class ExtensionFunctions {
    public static RationalNumber r(int value) {
        return new RationalNumber(value, 1);
    }

    public static RationalNumber r(Pair<Integer, Integer> pair) {
        return new RationalNumber(pair.getFirst(), pair.getSecond());
    }
}

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class RationalNumber {
    private final int numerator;
    private final int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "RationalNumber{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}


