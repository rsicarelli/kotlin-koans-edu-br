<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
// PHP suporta default arguments.
/** @noinspection PhpMissingReturnTypeInspection */

function foo($name, $number = 42, $toUpperCase = false)
{
    return ($toUpperCase ? strtoupper($name) : $name) . $number;
}

function useFoo()
{
    $result = [];
    $result[] = foo("a");
    $result[] = foo("b", 1);
    $result[] = foo("c", null, true);
    $result[] = foo("d", 2, true);
    return $result;
}

$result = useFoo();
echo implode(", ", $result);
