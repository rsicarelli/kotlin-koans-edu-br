/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// JavaScript suporta default arguments.
function foo(name, number = 42, toUpperCase = false) {
    return (toUpperCase ? name.toUpperCase() : name) + number;
}

const useFoo = () => [
    foo("a"),
    foo("b", 1),
    foo("c", undefined, true),
    foo("d", 2, true)
];

const result = useFoo();
console.log(result);
