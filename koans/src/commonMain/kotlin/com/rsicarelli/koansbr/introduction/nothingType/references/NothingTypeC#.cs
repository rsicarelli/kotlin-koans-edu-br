/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;

class Program
{
    static void Main(string[] args)
    {
        try
        {
            CheckAge(10);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine(ex.Message);
        }
    }

    static void FailWithWrongAge(int? age)
    {
        throw new ArgumentException($"Wrong age: {age}");
    }

    static void CheckAge(int? age)
    {
        if (age == null || age < 0 || age > 150) FailWithWrongAge(age);
        Console.WriteLine($"Congrats! Next year you'll be {age + 1}.");
    }
}
