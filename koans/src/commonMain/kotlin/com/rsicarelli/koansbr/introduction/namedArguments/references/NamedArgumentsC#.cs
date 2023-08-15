/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;
using System.Text;

public class Program
{
    public static string JoinOptions(List<string> options)
    {
        return "[" + string.Join(", ", options) + "]";
    }

    public static void Main()
    {
        Console.WriteLine(
            JoinOptions(
                new List<string>{ "Option 1", "Option 2", "Option 3" }
            ));  // Outputs: [Option 1, Option 2, Option 3]
    }
}
