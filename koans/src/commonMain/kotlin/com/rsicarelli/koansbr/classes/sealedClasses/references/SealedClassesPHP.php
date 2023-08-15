<?php

/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */

/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

abstract class Expr
{
}

final class Num extends Expr
{
    public $value;

    public function __construct($value)
    {
        $this->value = $value;
    }
}

final class Sum extends Expr
{
    public $left, $right;

    public function __construct($left, $right)
    {
        $this->left = $left;
        $this->right = $right;
    }
}

//eval é uma função interna do PHP e não pode ser redefinida. Por isso, renomeamos para algo diferente, por exemplo, evaluate.
/**
 * @throws Exception
 */
function evaluate($expr)
{
    if ($expr instanceof Num) {
        return $expr->value;
    } elseif ($expr instanceof Sum) {
        return evaluate($expr->left) + evaluate($expr->right);
    }
    throw new Exception("Unknown Expr type");
}
