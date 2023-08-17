/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// TypeScript suporta default arguments.
function foo(name: string, number: number = 42, toUpperCase: boolean = false): string {
    return (toUpperCase ? name.toUpperCase() : name) + number;
}

function useFoo(): string[] {
    return [
        foo("a"),
        foo("b", 1),
        foo("c", undefined, true),
        foo("d", 2, true)
    ];
}

const result = useFoo();
console.log(result);
