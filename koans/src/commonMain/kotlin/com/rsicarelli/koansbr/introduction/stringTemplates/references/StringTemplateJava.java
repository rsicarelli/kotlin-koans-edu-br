/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.stringTemplates.references;

@SuppressWarnings("unused")
public class StringTemplateJava {
    public static final String MONTH = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    public static void main(String[] args) {
        System.out.println(getPattern(MONTH));
    }

    @SuppressWarnings("SameParameterValue")
    static String getPattern(String month) {
        return "\\d{2} " + month + " \\d{4}";
    }
}
