<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

/** @noinspection PhpIllegalPsrClassPathInspection */

class Person
{
    public $name;
    public $age;

    public function __construct($name, $age)
    {
        $this->name = $name;
        $this->age = $age;
    }

    public function __toString()
    {
        return "Person{name: $this->name, age: $this->age}";
    }

    public function equals($other): bool
    {
        return $other instanceof Person && $this->name === $other->name && $this->age === $other->age;
    }
}

function getPeople(): array
{
    return [
        new Person('Alice', 29),
        new Person('Bob', 31),
    ];
}

function comparePeople(): bool
{
    $p1 = new Person('Alice', 29);
    $p2 = new Person('Alice', 29);
    return $p1->equals($p2); // true
}

$people = getPeople();
foreach ($people as $person) {
    echo $person . "\n";
}
echo comparePeople();
