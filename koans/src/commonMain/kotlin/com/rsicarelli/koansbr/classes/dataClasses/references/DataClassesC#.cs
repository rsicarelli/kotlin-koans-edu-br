/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

using System;
using System.Collections.Generic;

class Person
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
        return obj is Person person &&
               Name == person.Name &&
               Age == person.Age;
    }

    public override int GetHashCode()
    {
        return HashCode.Combine(Name, Age);
    }
}

class Program
{
    static void Main(string[] args)
    {
        List<Person> people = new List<Person>
        {
            new Person("Alice", 29),
            new Person("Bob", 31)
        };

        Person p1 = new Person("Alice", 29);
        Person p2 = new Person("Alice", 29);

        Console.WriteLine(string.Join(Environment.NewLine, people));
        Console.WriteLine(p1.Equals(p2));  // True
    }
}
