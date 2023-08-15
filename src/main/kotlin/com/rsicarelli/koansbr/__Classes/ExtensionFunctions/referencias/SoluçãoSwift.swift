struct RationalNumber {
    let numerator: Int
    let denominator: Int
}

extension Int {
    func r() -> RationalNumber {
        return RationalNumber(numerator: self, denominator: 1)
    }
}

extension Pair {
    func r() -> RationalNumber {
        return RationalNumber(numerator: self.first, denominator: self.second)
    }
}
