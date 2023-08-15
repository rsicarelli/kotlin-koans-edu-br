/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

public record RationalNumber(int Numerator, int Denominator);

public static class Extensions
{
    public static RationalNumber R(this int value)
    {
        return new RationalNumber(value, 1);
    }

    public static RationalNumber R(this ValueTuple<int, int> tuple)
    {
        return new RationalNumber(tuple.Item1, tuple.Item2);
    }
}
