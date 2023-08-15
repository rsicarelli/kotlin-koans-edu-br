/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.dataClasses.references;

import java.util.Arrays;
import java.util.List;

class DataClassesJava {
    public static void main(String[] args) {
        System.out.println(comparePeople());
    }

    static class PersonJava {
        final String name;
        final int age;

        PersonJava(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            PersonJava PersonJava = (PersonJava) obj;
            return age == PersonJava.age && name.equals(PersonJava.name);
        }
    }

    static List<PersonJava> getPeople() {
        return Arrays.asList(new PersonJava("Alice", 29), new PersonJava("Bob", 31));
    }

    static boolean comparePeople() {
        PersonJava p1 = new PersonJava("Alice", 29);
        PersonJava p2 = new PersonJava("Alice", 29);
        return p1.equals(p2); // should be true
    }
}
