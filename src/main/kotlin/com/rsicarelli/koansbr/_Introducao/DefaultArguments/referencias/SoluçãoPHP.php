<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

function foo($name, $number = 42, $toUpperCase = false): string
{
    if ($toUpperCase) {
        $name = strtoupper($name);
    }

    return $name . $number;
}

function useFoo(): array
{
    return array(
        foo("a"),
        foo("b", 1),
        foo("c", 42, true),
        foo("d", 2, true)
    );
}
