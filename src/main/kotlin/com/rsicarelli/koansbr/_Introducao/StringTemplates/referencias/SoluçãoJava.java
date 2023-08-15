/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package com.rsicarelli.koansbr._Introducao.StringTemplates.referencias;

public class SoluçãoJava {
    private static final String MONTH = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    public static String getPattern() {
        return "\\d{2} " + MONTH + " \\d{4}";
    }
}
