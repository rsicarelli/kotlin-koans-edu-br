using System;

public class Program
{
    public static void FailWithWrongAge(int? age)
    {
        throw new ArgumentException($"Wrong age: {age}");
    }

    public static void CheckAge(int? age)
    {
        if (age == null || age < 0 || age > 150) FailWithWrongAge(age);
        Console.WriteLine($"Congrats! Next year you'll be {age + 1}.");
    }

    public static void Main()
    {
        CheckAge(10);  // Outputs: Congrats! Next year you'll be 11.
    }
}
