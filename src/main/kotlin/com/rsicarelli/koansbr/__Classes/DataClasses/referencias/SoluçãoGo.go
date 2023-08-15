package main

import "fmt"

type Person struct {
	name string
	age  int
}

func getPeople() []Person {
	return []Person{{"Alice", 29}, {"Bob", 31}}
}

func comparePeople() bool {
	p1 := Person{"Alice", 29}
	p2 := Person{"Alice", 29}
	return p1 == p2 // should be true
}

func main() {
	fmt.Println(comparePeople())
}
