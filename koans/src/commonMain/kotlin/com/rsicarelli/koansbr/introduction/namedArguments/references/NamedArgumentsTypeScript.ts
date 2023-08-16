/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// TypeScript não suporta named arguments.

function joinOptions(options: string[]): string {
    return options.join(', ');
}

const options: string[] = ['Option 1', 'Option 2', 'Option 3'];
const result: string = joinOptions(options);
console.log(result);
