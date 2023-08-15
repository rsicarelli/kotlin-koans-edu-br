/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Person {
    name: string;
    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    equals(other: Person) {
        return this.name == other.name && this.age == other.age;
    }
}

function getPeople(): Person[] {
    return [new Person("Alice", 29), new Person("Bob", 31)];
}

function comparePeople(): boolean {
    let p1: Person = new Person("Alice", 29);
    let p2: Person = new Person("Alice", 29);
    return p1.equals(p2); // should be true
}

console.log(comparePeople())
