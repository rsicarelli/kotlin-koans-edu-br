class RationalNumber {
  final int numerator;
  final int denominator;

  RationalNumber(this.numerator, this.denominator);
}

extension IntRational on int {
  RationalNumber get r => RationalNumber(this, 1);
}
