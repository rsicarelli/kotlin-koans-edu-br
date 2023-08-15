/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

abstract class Expr {}

class Num implements Expr {
  final int value;

  Num(this.value);
}

class Sum implements Expr {
  final Expr left, right;

  Sum(this.left, this.right);
}

int eval(Expr expr) {
  if (expr is Num) {
    return expr.value;
  } else if (expr is Sum) {
    return eval(expr.left) + eval(expr.right);
  }
  throw ArgumentError('Unknown Expr type');
}
