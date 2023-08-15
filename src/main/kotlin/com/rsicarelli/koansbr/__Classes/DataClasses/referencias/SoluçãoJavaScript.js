class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    equals(other) {
        return this.name == other.name && this.age == other.age;
    }
}

getPeople = () => [new Person("Alice", 29), new Person("Bob", 31)];

comparePeople = () => {
    let p1 = new Person("Alice", 29);
    let p2 = new Person("Alice", 29);
    return p1.equals(p2); // should be true
}

console.log(comparePeople())
