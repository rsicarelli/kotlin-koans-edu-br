/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.renameOnImport.referencias;

import java.util.Random;

//Java 17 não suporta named imports
class RenameOnImportJava {

    public static String useDifferentRandomClasses() {
        return "Kotlin random: " +
                new KotlinRandom().nextInt(2) +
                " Java random:" +
                new Random().nextInt(2) +
                ".";
    }

    public static void main(String[] args) {
        System.out.println(useDifferentRandomClasses());
    }
}

class KotlinRandom {

    public int nextInt(int value) {
        return value;
    }
}
