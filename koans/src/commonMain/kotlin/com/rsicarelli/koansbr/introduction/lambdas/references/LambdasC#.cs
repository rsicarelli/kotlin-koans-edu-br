/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        List<int> collection = new List<int> { 1, 3, 5, 6, 9 };
        Console.WriteLine(ContainsEven(collection));
    }

    static bool ContainsEven(IEnumerable<int> collection)
    {
        return collection.Any(item => item % 2 == 0);
    }
}
