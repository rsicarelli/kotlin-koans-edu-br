/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
class Pair<T, U> {
    constructor(public first: T, public second: U) {
    }
}

class RationalNumber {
    constructor(public numerator: number, public denominator: number) {
    }
}

function rInt(value: number): RationalNumber {
    return new RationalNumber(value, 1);
}

function rPair(pair: Pair<number, number>): RationalNumber {
    return new RationalNumber(pair.first, pair.second);
}

const result1: RationalNumber = rInt(5);
const result2: RationalNumber = rPair(new Pair(7, 3));

console.log(result1);
console.log(result2);
