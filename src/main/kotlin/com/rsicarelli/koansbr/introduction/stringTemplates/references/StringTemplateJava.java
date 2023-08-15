/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.stringTemplates.references;

public class StringTemplateJava {
    private static final String MONTH = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    public static String getPatternJava() {
        return "\\d{2} " + MONTH + " \\d{4}";
    }
}
