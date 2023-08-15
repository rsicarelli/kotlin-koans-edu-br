from dataclasses import dataclass


@dataclass
class RationalNumber:
    numerator: int
    denominator: int


def r(self: int) -> RationalNumber:
    return RationalNumber(self, 1)


def r(self: tuple) -> RationalNumber:
    return RationalNumber(self[0], self[1])
