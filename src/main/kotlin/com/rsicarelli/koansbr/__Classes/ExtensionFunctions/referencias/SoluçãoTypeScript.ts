/*
* TypeScript (JavaScript) não suporta a extensão de tipos nativos com novos métodos, então, infelizmente, não seria possível ter uma tradução direta para TypeScript.
* */

class RationalNumber {
    numerator: number
    denominator: number

    constructor(numerator: number, denominator: number) {
        this.numerator = numerator
        this.denominator = denominator
    }
}

function R(i: number): RationalNumber {
    return new RationalNumber(i, 1);
}

function R2(a: number, b: number): RationalNumber {
    return new RationalNumber(a, b);
}
