/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.defaultArguments.references;

import java.util.ArrayList;
import java.util.List;

// Java não suporta default arguments.
public class DefaultArgumentsJava {
    public static String foo(String name, int number, boolean toUpperCase) {
        return (toUpperCase ? name.toUpperCase() : name) + number;
    }

    public static String foo(String name, int number) {
        return foo(name, number, false);
    }

    public static String foo(String name) {
        return foo(name, 42, false);
    }

    public static List<String> useFoo() {
        List<String> result = new ArrayList<>();
        result.add(foo("a"));
        result.add(foo("b", 1));
        result.add(foo("c", 42, true));
        result.add(foo("d", 2, true));
        return result;
    }

    public static void main(String[] args) {
        List<String> result = useFoo();
        System.out.println(result);
    }
}
