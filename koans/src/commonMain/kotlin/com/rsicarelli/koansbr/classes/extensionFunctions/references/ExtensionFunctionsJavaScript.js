/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

class Pair {
    constructor(first, second) {
        this.first = first;
        this.second = second;
    }
}

class RationalNumber {
    constructor(numerator, denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}

Number.prototype.r = function () {
    return new RationalNumber(this, 1);
};

Pair.prototype.r = function () {
    return new RationalNumber(this.first, this.second);
};

const result1 = (5).r();
const result2 = new Pair(7, 3).r();

console.log(result1);
console.log(result2);
