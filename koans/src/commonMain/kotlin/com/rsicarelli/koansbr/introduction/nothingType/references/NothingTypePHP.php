<?php
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
function main()
{
    try {
        checkAge(10);
    } catch (Exception $e) {
        echo $e->getMessage();
    }
}

/**
 * @throws Exception
 */
function failWithWrongAge($age)
{
    throw new Exception("Wrong age: $age");
}

/**
 * @throws Exception
 */
function checkAge($age)
{
    if ($age === null || $age < 0 || $age > 150) {
        failWithWrongAge($age);
    }
    echo "Congrats! Next year you'll be " . ($age + 1) . ".";
}

main();
