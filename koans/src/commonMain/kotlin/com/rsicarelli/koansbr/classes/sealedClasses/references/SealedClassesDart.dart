/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

abstract class Expr {
  factory Expr.num(int value) = Num;

  factory Expr.sum(Expr left, Expr right) = Sum;
}

class Num implements Expr {
  final int value;

  Num(this.value);
}

class Sum implements Expr {
  final Expr left, right;

  Sum(this.left, this.right);
}

// Evaluation function
int eval(Expr expr) {
  if (expr is Num) {
    return expr.value;
  } else if (expr is Sum) {
    return eval(expr.left) + eval(expr.right);
  } else {
    throw Exception('Unknown Expr type');
  }
}
