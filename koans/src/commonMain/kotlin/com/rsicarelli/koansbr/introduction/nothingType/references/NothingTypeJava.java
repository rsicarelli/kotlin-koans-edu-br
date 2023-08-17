/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.introduction.nothingType.references;

public class NothingTypeJava {
    static void failWithWrongAge(Integer age) {
        throw new IllegalArgumentException("Wrong age: " + age);
    }

    @SuppressWarnings("SameParameterValue") //Apenas para demonstrações, comparando o tipo "Nothing" do Kotlin.
    static void checkAge(Integer age) {
        if (age == null || age < 0 || age > 150) {
            failWithWrongAge(age);
        } else {
            System.out.println("Congrats! Next year you'll be " + (age + 1));
        }
    }

    public static void main(String[] args) {
        checkAge(10);
    }
}
