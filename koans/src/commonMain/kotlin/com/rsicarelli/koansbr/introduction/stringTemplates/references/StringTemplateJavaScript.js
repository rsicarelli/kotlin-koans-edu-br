/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const month = '(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

function getPattern(month) {
    return `\\d{2} ${month} \\d{4}`;
}

function main() {
    console.log(getPattern(month));
}

main();
