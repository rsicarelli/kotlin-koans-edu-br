using System;
using System.Collections.Generic;
using System.Text;

public class Program
{
    public static string JoinOptions(List<string> options)
    {
        return "[" + string.Join(", ", options) + "]";
    }

    public static void Main()
    {
        Console.WriteLine(
            JoinOptions(
                new List<string>{ "Option 1", "Option 2", "Option 3" }
            ));  // Outputs: [Option 1, Option 2, Option 3]
    }
}
