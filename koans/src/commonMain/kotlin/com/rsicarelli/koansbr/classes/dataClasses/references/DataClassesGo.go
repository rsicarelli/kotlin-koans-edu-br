/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import "fmt"

type Person struct {
	Name string
	Age  int
}

func (p Person) Equals(other Person) bool {
	return p.Name == other.Name && p.Age == other.Age
}

func (p Person) String() string {
	return fmt.Sprintf("Person{Name: %s, Age: %d}", p.Name, p.Age)
}

func getPeople() []Person {
	return []Person{
		{"Alice", 29},
		{"Bob", 31},
	}
}

func comparePeople() bool {
	p1 := Person{"Alice", 29}
	p2 := Person{"Alice", 29}
	return p1.Equals(p2) // true
}

func main() {
	people := getPeople()
	for _, person := range people {
		fmt.Println(person)
	}
	fmt.Println(comparePeople())
}
