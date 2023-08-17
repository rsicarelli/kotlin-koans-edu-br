/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;

class Program
{
    static void Main(string[] args)
    {
        RationalNumber result1 = ExtensionFunctions.R(5);
        RationalNumber result2 = ExtensionFunctions.R(new Pair<int, int>(7, 3));

        Console.WriteLine(result1);
        Console.WriteLine(result2);
    }
}

static class ExtensionFunctions
{
    public static RationalNumber R(this int value)
    {
        return new RationalNumber(value, 1);
    }

    public static RationalNumber R(this Tuple<int, int> pair)
    {
        return new RationalNumber(pair.Item1, pair.Item2);
    }
}

class Pair<T, U>
{
    public T First { get; }
    public U Second { get; }

    public Pair(T first, U second)
    {
        First = first;
        Second = second;
    }
}

class RationalNumber
{
    public int Numerator { get; }
    public int Denominator { get; }

    public RationalNumber(int numerator, int denominator)
    {
        Numerator = numerator;
        Denominator = denominator;
    }

    public override string ToString()
    {
        return $"RationalNumber{{Numerator={Numerator}, Denominator={Denominator}}}";
    }
}
