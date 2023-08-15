/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.renameOnImport.referencias;

class RenameOnImportJava {

    public static String useDifferentRandomClasses() {
        return "Kotlin random: " +
                new KotlinRandom().nextInt(2) +
                " Java random:" +
                new JavaRandom().nextInt(2) +
                ".";
    }

    public static void main(String[] args) {
        System.out.println(useDifferentRandomClasses());
    }
}

class JavaRandom {

    public int nextInt(int value) {
        return value;
    }
}

class KotlinRandom {

    public int nextInt(int value) {
        return value;
    }
}
