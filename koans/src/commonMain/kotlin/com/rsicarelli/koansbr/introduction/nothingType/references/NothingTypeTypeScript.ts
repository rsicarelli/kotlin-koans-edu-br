/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const main = () => {
    try {
        checkAge(10);
    } catch (error) {
        console.log(error.message);
    }
};

class CustomError extends Error {
    constructor(message: string) {
        super(message);
        this.name = "CustomError";
    }
}

function failWithWrongAge(age: number): never {
    throw new CustomError(`Wrong age: ${age}`);
}

function checkAge(age: number | null): void {
    if (age === null || age < 0 || age > 150) {
        failWithWrongAge(age);
    }
    console.log(`Congrats! Next year you'll be ${age + 1}.`);
}

main();
