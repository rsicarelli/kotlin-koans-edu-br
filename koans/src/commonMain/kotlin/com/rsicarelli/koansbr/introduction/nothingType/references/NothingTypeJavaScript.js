/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

function main() {
    try {
        checkAge(10);
    } catch (error) {
        console.log(error.message);
    }
}

function failWithWrongAge(age) {
    throw new Error(`Wrong age: ${age}`);
}

function checkAge(age) {
    if (age === null || age < 0 || age > 150) {
        failWithWrongAge(age);
    }
    console.log(`Congrats! Next year you'll be ${age + 1}.`);
}

main();
