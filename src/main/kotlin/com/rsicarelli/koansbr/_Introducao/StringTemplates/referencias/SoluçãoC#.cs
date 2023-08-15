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
