<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
$month = '(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

function getPattern($month): string
{
    return "\\d{2} $month \\d{4}";
}

function main()
{
    global $month;
    echo getPattern($month);
}

main();
