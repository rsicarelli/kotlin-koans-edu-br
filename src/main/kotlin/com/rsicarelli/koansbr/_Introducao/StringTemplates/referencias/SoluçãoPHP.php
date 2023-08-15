<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

const MONTH = '(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)';

function getPattern(): string
{
    return '/\d{2} ' . MONTH . ' \d{4}/';
}

echo getPattern();
