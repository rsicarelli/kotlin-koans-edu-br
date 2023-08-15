/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
public class Program
{
    const string Month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)";

    public static string GetPattern()
    {
        return "\\d{2} " + Month + " \\d{4}";
    }

    public static void Main()
    {
        Console.WriteLine(GetPattern());
    }
}
