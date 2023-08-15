/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Person {
  String name;
  int age;

  Person(this.name, this.age);

  bool operator ==(var other) {
    return other is Person && other.name == name && other.age == age;
  }

  int get hashCode => name.hashCode ^ age.hashCode;
}

List<Person> getPeople() {
  return [Person('Alice', 29), Person('Bob', 31)];
}

bool comparePeople() {
  var p1 = Person('Alice', 29);
  var p2 = Person('Alice', 29);
  return p1 == p2; // should be true
}

main() {
  print(comparePeople());
}
