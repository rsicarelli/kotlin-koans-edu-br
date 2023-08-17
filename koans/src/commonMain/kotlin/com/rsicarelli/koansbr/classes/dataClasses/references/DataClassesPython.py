#  SPDX-License-Identifier: MIT
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#
#
#
#

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __eq__(self, other):
        if isinstance(other, Person):
            return self.name == other.name and self.age == other.age
        return False

    def __str__(self):
        return f"Person(name='{self.name}', age={self.age})"


def get_people():
    return [
        Person(name="Alice", age=29),
        Person(name="Bob", age=31)
    ]


def compare_people():
    p1 = Person("Alice", 29)
    p2 = Person("Alice", 29)
    return p1 == p2  # True


people = get_people()
print("\n".join(map(str, people)))
print(compare_people())
