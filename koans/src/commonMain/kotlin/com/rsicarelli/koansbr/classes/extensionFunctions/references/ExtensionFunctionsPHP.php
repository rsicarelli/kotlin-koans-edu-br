<?php

/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */

class RationalNumber
{
    public $numerator;
    public $denominator;

    public function __construct(int $numerator, int $denominator)
    {
        $this->numerator = $numerator;
        $this->denominator = $denominator;
    }
}

function R($i)
{
    return new RationalNumber($i, 1);
}

function R2($a, $b)
{
    return new RationalNumber($a, $b);
}
