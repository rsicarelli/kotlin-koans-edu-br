<?php
/** @noinspection PhpMultipleClassesDeclarationsInOneFile */

/** @noinspection PhpIllegalPsrClassPathInspection */

/** @noinspection PhpMultipleClassDeclarationsInspection */


interface Expr
{
}

class Num implements Expr
{
    public $value;

    public function __construct($value)
    {
        $this->value = $value;
    }
}

class Sum implements Expr
{
    public $left, $right;

    public function __construct(Expr $left, Expr $right)
    {
        $this->left = $left;
        $this->right = $right;
    }
}

/**
 * @throws Exception
 */
function evaluateExpr(Expr $expr)
{
    if ($expr instanceof Num) {
        return $expr->value;
    } elseif ($expr instanceof Sum) {
        return evaluateExpr($expr->left) + evaluateExpr($expr->right);
    } else {
        throw new Exception('Unknown expression');
    }
}

