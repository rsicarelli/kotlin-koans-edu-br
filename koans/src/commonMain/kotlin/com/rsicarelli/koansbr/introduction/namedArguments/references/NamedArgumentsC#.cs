/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
using System;
using System.Collections.Generic;

// C# não suporta named arguments.
class NamedArgumentsCsharp
{
    static string JoinOptions(List<string> options)
    {
        return string.Join(", ", options);
    }

    static void Main()
    {
        List<string> options = new List<string> { "Option 1", "Option 2", "Option 3" };
        string result = JoinOptions(options);
        Console.WriteLine(result);
    }
}
