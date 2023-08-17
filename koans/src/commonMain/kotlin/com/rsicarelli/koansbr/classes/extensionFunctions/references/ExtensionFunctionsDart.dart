/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Pair<T, U> {
  final T first;
  final U second;

  Pair(this.first, this.second);
}

class RationalNumber {
  final int numerator;
  final int denominator;

  RationalNumber(this.numerator, this.denominator);
}

extension IntExtension on int {
  RationalNumber r() {
    return RationalNumber(this, 1);
  }
}

extension PairExtension<T, U> on Pair<T, U> {
  RationalNumber r() {
    return RationalNumber(this.first as int, this.second as int);
  }
}

void main() {
  final result1 = 5.r();
  final result2 = Pair(7, 3).r();

  print(result1);
  print(result2);
}
