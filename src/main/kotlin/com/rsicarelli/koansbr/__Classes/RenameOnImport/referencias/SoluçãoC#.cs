using JRandom = JavaRandom;
using KRandom = KotlinRandom;

public class JavaRandom {

    public int NextInt(int value) {
        return 0;
    }
}

public class KotlinRandom {

    public int NextInt(int value) {
        return 0;
    }
}

public class Test {

    public static string UseDifferentRandomClasses() {
        return "Kotlin random: " +
            new KRandom().NextInt(2) +
            " Java random:" +
            new JRandom().NextInt(2) +
            ".";
    }

    public static void Main(string[] args) {
        System.Console.WriteLine(UseDifferentRandomClasses());
    }
}
