/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
using System;

public class Program
{
    const string Question = "life, the universe, and everything";
    const int Answer = 42;

    public static string TripleQuotedString()
    {
        return $@"#question = ""{Question}""
                #answer = {Answer}
                ".TrimStart('#').TrimEnd('#');
    }

    public static void Main()
    {
        Console.WriteLine(TripleQuotedString());
    }
}
