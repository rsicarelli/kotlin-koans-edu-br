/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.tripleQuotedStrings.references;

public class TripleQuotedJava {

    public static final String question = "life, the universe, and everything";
    public static final int answer = 42;

    /*
     * A sintaxe de blocos de texto multilinha não é suportada no Java até a versão 15.
     * A maneira mais próxima de alcançar algo semelhante em Java é concatenando várias strings.
     * */
    public static void main(String[] args) {
        String tripleQuotedString =
                "#question = \"" + question + "\"\n" +
                        "#answer = " + answer;

        System.out.println(tripleQuotedString);
    }
}
