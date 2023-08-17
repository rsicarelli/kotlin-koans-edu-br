/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.dataClasses.references;

import java.util.List;
import java.util.Objects;

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

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

