/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.dataClasses.references;

import java.util.List;

public class DataClassesJava {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 29),
                new Person("Bob", 31)
        );

        Person p1 = new Person("Alice", 29);
        Person p2 = new Person("Alice", 29);

        System.out.println(people);
        System.out.println(p1.equals(p2));  // true
    }
}

record Person(String name, int age) {
}
