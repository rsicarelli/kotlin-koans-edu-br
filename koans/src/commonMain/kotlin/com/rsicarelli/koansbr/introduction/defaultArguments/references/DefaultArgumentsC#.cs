/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;

public class Program
{
    public static string Foo(string name, int number = 42, bool toUppercase = false)
    {
        return (toUppercase ? name.ToUpper() : name) + number;
    }

    public static List<string> UseFoo()
    {
        return new List<string>
        {
            Foo(name: "a"),
            Foo(name: "b", number: 1),
            Foo(name: "c", toUppercase: true),
            Foo(name: "d", number: 2, toUppercase: true)
        };
    }

    public static void Main()
    {
        Console.WriteLine(string.Join(", ", UseFoo()));
    }
}
