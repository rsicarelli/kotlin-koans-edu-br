/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.tripleQuotedStrings.references;

public class TripleQuotedJava {

    public static final String QUESTION = "life, the universe, and everything";
    public static final int ANSWER = 42;

    public static void main(String[] args) {
        String tripleQuotedString = """
                #question = "%s"
                #answer = %d
                """.formatted(QUESTION, ANSWER)
                .stripIndent()
                .replaceFirst("\n", "");

        System.out.println(tripleQuotedString);
    }
}
