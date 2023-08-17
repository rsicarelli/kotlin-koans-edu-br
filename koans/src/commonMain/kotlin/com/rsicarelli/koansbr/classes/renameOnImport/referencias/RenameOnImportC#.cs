/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using JRandom = JavaRandom;
using KRandom = KotlinRandom;

public class JavaRandom {

    public int NextInt(int value) {
        return value;
    }
}

public class KotlinRandom {

    public int NextInt(int value) {
        return value;
    }
}

public class Test {

    public static string UseDifferentRandomClasses() {
        return "Kotlin random: " +
            new KRandom().NextInt(2) +
            " Java random:" +
            new JRandom().NextInt(2) +
            ".";
    }

    public static void Main(string[] args) {
        System.Console.WriteLine(UseDifferentRandomClasses());
    }
}
