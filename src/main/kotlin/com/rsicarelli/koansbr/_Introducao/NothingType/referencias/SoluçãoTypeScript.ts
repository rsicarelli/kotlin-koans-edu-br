/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

function failWithWrongAge(age: number | null): never {
    throw new Error("Wrong age: " + age);
}

function checkAge(age: number | null): void {
    if (age === null || age < 0 || age > 150) {
        failWithWrongAge(age);
    } else {
        console.log("Congrats! Next year you'll be " + (age + 1));
    }
}

checkAge(10);
