/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;

public class Program
{
    public static void FailWithWrongAge(int? age)
    {
        throw new ArgumentException($"Wrong age: {age}");
    }

    public static void CheckAge(int? age)
    {
        if (age == null || age < 0 || age > 150) FailWithWrongAge(age);
        Console.WriteLine($"Congrats! Next year you'll be {age + 1}.");
    }

    public static void Main()
    {
        CheckAge(10);  // Outputs: Congrats! Next year you'll be 11.
    }
}
