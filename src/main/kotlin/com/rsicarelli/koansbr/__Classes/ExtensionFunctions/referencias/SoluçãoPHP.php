PHP não suporta tipos estáticos ou extensão de classes fundamentais, por isso não temos uma tradução direta para PHP.

<?php

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
