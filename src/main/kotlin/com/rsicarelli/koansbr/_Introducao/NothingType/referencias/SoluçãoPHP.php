<?php

function failWithWrongAge($age)
{
    throw new InvalidArgumentException("Wrong age: $age");
}

function checkAge($age)
{
    if ($age === null || $age < 0 || $age > 150) failWithWrongAge($age);
    echo "Congrats! Next year you'll be " . ($age + 1) . ".";
}

checkAge(10);
