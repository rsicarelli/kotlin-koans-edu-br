/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package com.rsicarelli.koansbr._Introducao.DefaultArguments.referencias;

import java.util.Arrays;
import java.util.List;

public class SoluçãoJava {
    public static String foo(String name, Integer number, Boolean toUpperCase) {
        if (number == null) number = 42;
        if (toUpperCase == null) toUpperCase = false;
        return (toUpperCase ? name.toUpperCase() : name) + number;
    }

    public static List<String> useFoo() {
        return Arrays.asList(
                foo("a", null, null),
                foo("b", 1, null),
                foo("c", null, true),
                foo("d", 2, true)
        );
    }
}
