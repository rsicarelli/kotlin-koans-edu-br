package com.rsicarelli.koansbr._Introducao.Lambdas.referencias;

import java.util.Collection;

public class SoluçãoJava {
    public static boolean containsEven(Collection<Integer> collection) {
        return collection.stream().anyMatch(num -> num % 2 == 0);
    }
}
