/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class RationalNumber {
  final int numerator;
  final int denominator;

  RationalNumber(this.numerator, this.denominator);
}

extension IntRational on int {
  RationalNumber get r => RationalNumber(this, 1);
}
