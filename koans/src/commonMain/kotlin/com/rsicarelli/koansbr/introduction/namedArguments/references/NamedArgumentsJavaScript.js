/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

// JavaScript não suporta named arguments.

function joinOptions(options) {
    return options.join(', ');
}

const options = ['Option 1', 'Option 2', 'Option 3'];
const result = joinOptions(options);
console.log(result);
