<?php

/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */

/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

abstract class Expr
{
}

class Num extends Expr
{
    public $value;

    public function __construct($value)
    {
        $this->value = $value;
    }
}

class Sum extends Expr
{
    public $left, $right;

    public function __construct($left, $right)
    {
        $this->left = $left;
        $this->right = $right;
    }
}

/**
 * @throws Exception
 */
function evaluate($expr)
{
    if ($expr instanceof Num) {
        return $expr->value;
    } elseif ($expr instanceof Sum) {
        return evaluate($expr->left) + evaluate($expr->right);
    } else {
        throw new Exception("Unknown Expr type");
    }
}
