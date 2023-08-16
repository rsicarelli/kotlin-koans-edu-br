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

# Python suporta default arguments.

def foo(name, number=42, to_upper_case=False):
    return (name.upper() if to_upper_case else name) + str(number)


def use_foo():
    return [
        foo("a"),
        foo("b", number=1),
        foo("c", to_upper_case=True),
        foo("d", number=2, to_upper_case=True)
    ]


result = use_foo()
print(result)
