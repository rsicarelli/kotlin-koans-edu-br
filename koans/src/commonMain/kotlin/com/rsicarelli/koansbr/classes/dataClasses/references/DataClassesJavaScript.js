/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    equals(other) {
        return other instanceof Person && this.name === other.name && this.age === other.age;
    }

    toString() {
        return `Person{name: ${this.name}, age: ${this.age}}`;
    }
}

function getPeople() {
    return [
        new Person('Alice', 29),
        new Person('Bob', 31),
    ];
}

function comparePeople() {
    const p1 = new Person('Alice', 29);
    const p2 = new Person('Alice', 29);
    return p1.equals(p2); // true
}

const people = getPeople();
console.log(people.map(String));
console.log(comparePeople());
