#  SPDX-License-Identifier: MIT
#  Copyright (c) 2023-2023 Rodrigo Sicarelli

from abc import ABC


class Expr(ABC):
    pass


class Num(Expr):
    def __init__(self, value):
        self.value = value


class Sum(Expr):
    def __init__(self, left, right):
        self.left = left
        self.right = right


def eval(expr):
    if isinstance(expr, Num):
        return expr.value
    elif isinstance(expr, Sum):
        return eval(expr.left) + eval(expr.right)
    else:
        raise ValueError("Unknown Expr type")
