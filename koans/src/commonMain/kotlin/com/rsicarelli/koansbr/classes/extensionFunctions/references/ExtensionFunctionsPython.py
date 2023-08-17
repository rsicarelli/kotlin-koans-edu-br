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
class Pair:
    def __init__(self, first, second):
        self.first = first
        self.second = second


class RationalNumber:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator


def r_int(value):
    return RationalNumber(value, 1)


def r_pair(pair):
    return RationalNumber(pair.first, pair.second)


result1 = r_int(5)
result2 = r_pair(Pair(7, 3))

print(result1)
print(result2)
