/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
using System;

class Program
{
    const string question = "life, the universe, and everything";
    const int answer = 42;

    static readonly string tripleQuotedString = @$"
    #question = ""{question}""
    #answer = {answer}
    ".Trim().Replace("#", "");

    static void Main(string[] args)
    {
        Console.WriteLine(tripleQuotedString);
    }
}
