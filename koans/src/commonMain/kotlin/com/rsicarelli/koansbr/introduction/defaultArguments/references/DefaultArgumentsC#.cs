/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;
using System;
using System.Collections.Generic;

// C# suporta default arguments.
class Program
{
    static string Foo(string name, int number = 42, bool toUpperCase = false)
    {
        return (toUpperCase ? name.ToUpper() : name) + number;
    }

    static List<string> UseFoo()
    {
        List<string> result = new List<string>();
        result.Add(Foo(name: "a"));
        result.Add(Foo(name: "b", number: 1));
        result.Add(Foo(name: "c", toUpperCase: true));
        result.Add(Foo(name: "d", number: 2, toUpperCase: true));
        return result;
    }

    static void Main()
    {
        List<string> result = UseFoo();
        Console.WriteLine(string.Join(", ", result));
    }
}
