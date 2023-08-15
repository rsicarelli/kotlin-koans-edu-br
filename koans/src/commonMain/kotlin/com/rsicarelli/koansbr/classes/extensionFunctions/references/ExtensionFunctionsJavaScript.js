/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class RationalNumber {
    constructor(numerator, denominator) {
        this.numerator = numerator
        this.denominator = denominator
    }
}

function R(i) {
    return new RationalNumber(i, 1);
}

function R2(a, b) {
    return new RationalNumber(a, b);
}
