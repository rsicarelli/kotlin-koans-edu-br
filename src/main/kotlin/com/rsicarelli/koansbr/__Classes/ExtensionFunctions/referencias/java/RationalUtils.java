package com.rsicarelli.koansbr.__Classes.ExtensionFunctions.referencias.java;

public class RationalUtils {
    public static RationalNumberJava r(int n) {
        return new RationalNumberJava(n, 1);
    }

    public static RationalNumberJava r(int numerator, int denominator) {
        return new RationalNumberJava(numerator, denominator);
    }
}
