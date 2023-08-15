#  SPDX-License-Identifier: MIT
#  Copyright (c) 2014-2019 JetBrains s.r.o.
#  Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#
#
#
#

from collections import namedtuple

Person = namedtuple('com.rsicarelli.koansbr.classes.dataClasses.Person', ['name', 'age'])


def get_people():
    return [
        Person(name="Alice", age=29),
        Person(name="Bob", age=31)
    ]


def compare_people():
    p1 = Person("Alice", 29)
    p2 = Person("Alice", 29)
    return p1 == p2  # should be True
