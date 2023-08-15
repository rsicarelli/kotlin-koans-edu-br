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
