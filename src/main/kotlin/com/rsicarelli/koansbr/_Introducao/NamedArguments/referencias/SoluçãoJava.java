package com.rsicarelli.koansbr._Introducao.NamedArguments.referencias;

import java.util.Collection;

public class SoluçãoJava {
    public static String joinOptions(Collection<String> options) {
        return "[" + String.join(", ", options) + "]";
    }
}
