/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package com.rsicarelli.koansbr._Introducao.TripleQuotedStrings.referencias;

public class SoluçãoJava {

    public static void main(String[] args) {
        String question = "life, the universe, and everything";
        int answer = 42;

        String tripleQuotedString = "#question = \"" + question + "\"\n#answer = " + answer;
        tripleQuotedString = tripleQuotedString.trim();

        System.out.println(tripleQuotedString);
    }
}
