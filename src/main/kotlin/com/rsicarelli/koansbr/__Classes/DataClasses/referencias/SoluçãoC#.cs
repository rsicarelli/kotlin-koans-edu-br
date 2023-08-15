/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;

public class Person
{
    public string Name { get; }
    public int Age { get; }

    public Person(string name, int age)
    {
        Name = name;
        Age = age;
    }

    public override bool Equals(object obj)
    {
        var person = obj as Person;
        if (person == null)
            return false;

        return Name == person.Name && Age == person.Age;
    }

    public override int GetHashCode()
    {
        unchecked
        {
            int hash = 17;
            hash = hash * 23 + (Name != null ? Name.GetHashCode() : 0);
            hash = hash * 23 + Age.GetHashCode();
            return hash;
        }
    }
}

public static class MainClass
{
    public static List<Person> GetPeople()
    {
        return new List<Person>
        {
            new Person("Alice", 29),
            new Person("Bob", 31),
        };
    }

    public static bool ComparePeople()
    {
        var p1 = new Person("Alice", 29);
        var p2 = new Person("Alice", 29);
        return p1.Equals(p2); // should be true
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(ComparePeople());
    }
}
