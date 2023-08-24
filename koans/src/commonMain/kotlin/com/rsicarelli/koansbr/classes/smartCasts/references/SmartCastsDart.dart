/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

int eval(Expr expr) {
  if (expr is Num) {
    return expr.value;
  } else if (expr is Sum) {
    return eval(expr.left) + eval(expr.right);
  } else {
    throw ArgumentError('Unknown expression');
  }
}

abstract class Expr {}

class Num implements Expr {
  final int value;

  Num(this.value);
}

class Sum implements Expr {
  final Expr left, right;

  Sum(this.left, this.right);
}
