/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.tripleQuotedStrings.references;

public class TripleQuotedJava {

    public static void main(String[] args) {
        String question = "life, the universe, and everything";
        int answer = 42;

        String tripleQuotedString = "#question = \"" + question + "\"\n#com.rsicarelli.koansbr.introduction.tripleQuotedStrings.answer = " + answer;
        tripleQuotedString = tripleQuotedString.trim();

        System.out.println(tripleQuotedString);
    }
}