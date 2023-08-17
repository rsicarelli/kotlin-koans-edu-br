<?php

/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */

/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

class Pair
{
    public $first;
    public $second;

    public function __construct($first, $second)
    {
        $this->first = $first;
        $this->second = $second;
    }
}

class RationalNumber
{
    public $numerator;
    public $denominator;

    public function __construct($numerator, $denominator)
    {
        $this->numerator = $numerator;
        $this->denominator = $denominator;
    }
}

function r_int($value): RationalNumber
{
    return new RationalNumber($value, 1);
}

function r_pair($pair): RationalNumber
{
    return new RationalNumber($pair->first, $pair->second);
}

$result1 = r_int(5);
$result2 = r_pair(new Pair(7, 3));
