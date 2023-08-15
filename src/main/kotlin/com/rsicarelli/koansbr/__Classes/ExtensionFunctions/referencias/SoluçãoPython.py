#  *SPDX-License-Identifier: MIT
#  *Copyright (c) 2023-2023 Rodrigo Sicarelli
#
#
#
#
#

from dataclasses import dataclass


@dataclass
class RationalNumber:
    numerator: int
    denominator: int


def r(self: int) -> RationalNumber:
    return RationalNumber(self, 1)


def r(self: tuple) -> RationalNumber:
    return RationalNumber(self[0], self[1])
