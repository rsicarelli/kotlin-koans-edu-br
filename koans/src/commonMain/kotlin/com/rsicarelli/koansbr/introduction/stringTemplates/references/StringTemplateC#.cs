/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
using System;

class Program
{
    const string month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    static void Main(string[] args)
    {
        Console.WriteLine(GetPattern());
    }

    static string GetPattern()
    {
        return @"\d{2} " + month + @" \d{4}";
    }
}
