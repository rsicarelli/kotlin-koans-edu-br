using System;

    public class Program
    {
        const string Question = "life, the universe, and everything";
        const int Answer = 42;

        public static string TripleQuotedString()
        {
            return $@"#question = ""{Question}""
    #answer = {Answer}
    ".TrimStart('#').TrimEnd('#');
        }

        public static void Main()
        {
            Console.WriteLine(TripleQuotedString());
        }
    }
