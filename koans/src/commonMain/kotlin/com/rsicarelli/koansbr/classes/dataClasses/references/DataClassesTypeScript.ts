/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
class Person {
    constructor(public name: string, public age: number) {
    }

    equals(other: Person): boolean {
        return this.name === other.name && this.age === other.age;
    }

    toString(): string {
        return `Person{name: ${this.name}, age: ${this.age}}`;
    }
}

function getPeople(): Person[] {
    return [
        new Person('Alice', 29),
        new Person('Bob', 31)
    ];
}

function comparePeople(): boolean {
    const p1: Person = new Person('Alice', 29);
    const p2: Person = new Person('Alice', 29);
    return p1.equals(p2); // true
}

const people: Person[] = getPeople();
console.log(people.map(String));
console.log(comparePeople());
