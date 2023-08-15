using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static bool ContainsEven(List<int> collection)
    {
        return collection.Any(number => number % 2 == 0);
    }

    public static void Main()
    {
        Console.WriteLine(ContainsEven(new List<int>{1, 3, 5}));  // Outputs: False
        Console.WriteLine(ContainsEven(new List<int>{1, 2, 3}));  // Outputs: True
    }
}
