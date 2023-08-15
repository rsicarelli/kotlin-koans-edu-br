#  SPDX-License-Identifier: MIT
#  Copyright (c) 2014-2019 JetBrains s.r.o.
#  Copyright (c) 2023 Rodrigo Sicarelli

class Expr:
    pass


class Num(Expr):
    def __init__(self, value):
        self.value = value


class Sum(Expr):
    def __init__(self, left, right):
        self.left = left
        self.right = right


def evaluate(expr):
    if isinstance(expr, Num):
        return expr.value
    elif isinstance(expr, Sum):
        return eval(expr.left) + eval(expr.right)
    raise ValueError("Unknown Expr type")
