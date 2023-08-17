/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.namedArguments.references;

import java.util.List;

// Java não suporta named arguments
public class NamedArgumentsJava {
    public static String joinOptions(List<String> options) {
        return String.join(", ", options);
    }

    public static void main(String[] args) {
        List<String> options = List.of("Option 1", "Option 2", "Option 3");
        String result = joinOptions(options);
        System.out.println(result);
    }
}

