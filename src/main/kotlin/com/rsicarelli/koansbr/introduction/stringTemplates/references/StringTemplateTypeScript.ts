/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

const month: string = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

// noinspection JSUnusedGlobalSymbols
function getPattern(): string {
    return `\\d{2} ${month} \\d{4}`;
}
