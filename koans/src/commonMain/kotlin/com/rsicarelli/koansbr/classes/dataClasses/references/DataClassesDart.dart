/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Person {
  final String name;
  final int age;

  Person(this.name, this.age);

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Person &&
          runtimeType == other.runtimeType &&
          name == other.name &&
          age == other.age;

  @override
  int get hashCode => name.hashCode ^ age.hashCode;

  @override
  String toString() => 'Person{name: $name, age: $age}';
}

List<Person> getPeople() {
  return [
    Person('Alice', 29),
    Person('Bob', 31),
  ];
}

bool comparePeople() {
  final p1 = Person('Alice', 29);
  final p2 = Person('Alice', 29);
  return p1 == p2; // true
}

void main() {
  final people = getPeople();
  print(people);
  print(comparePeople());
}
