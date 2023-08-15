/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

/*
* JavaScript não suporta tipos estáticos ou extensão de tipos primitivos, então desta forma não seria possível ter uma tradução direta para JavaScript.
* */

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
