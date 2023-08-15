/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.ExtensionFunctions.referencias.java;

public class RationalUtils {
    public static RationalNumberJava r(int n) {
        return new RationalNumberJava(n, 1);
    }

    public static RationalNumberJava r(int numerator, int denominator) {
        return new RationalNumberJava(numerator, denominator);
    }
}
