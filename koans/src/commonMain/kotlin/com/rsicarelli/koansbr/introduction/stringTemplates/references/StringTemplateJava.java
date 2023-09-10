/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.stringTemplates.references;

@SuppressWarnings("unused")
public class StringTemplateJava {

    public static final String MONTH = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    public static String getPattern() {
        return """
                \\d{2} %s \\d{4}""".formatted(MONTH).strip();
    }

    public static void main(String[] args) {
        System.out.println(getPattern());
    }
}
