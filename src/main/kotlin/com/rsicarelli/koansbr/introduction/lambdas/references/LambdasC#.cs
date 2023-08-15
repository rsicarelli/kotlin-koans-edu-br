/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static bool ContainsEven(List<int> collection)
    {
        return collection.Any(number => number % 2 == 0);
    }

    public static void Main()
    {
        Console.WriteLine(ContainsEven(new List<int>{1, 3, 5}));  // Outputs: False
        Console.WriteLine(ContainsEven(new List<int>{1, 2, 3}));  // Outputs: True
    }
}
