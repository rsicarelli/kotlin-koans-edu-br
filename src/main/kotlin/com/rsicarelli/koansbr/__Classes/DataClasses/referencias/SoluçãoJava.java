package com.rsicarelli.koansbr.__Classes.DataClasses.referencias;

import java.util.Arrays;
import java.util.List;

class SoluçãoJava {
    public static void main(String[] args) {
        System.out.println(comparePeople());
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }
    }

    static List<Person> getPeople() {
        return Arrays.asList(new Person("Alice", 29), new Person("Bob", 31));
    }

    static boolean comparePeople() {
        Person p1 = new Person("Alice", 29);
        Person p2 = new Person("Alice", 29);
        return p1.equals(p2); // should be true
    }
}
