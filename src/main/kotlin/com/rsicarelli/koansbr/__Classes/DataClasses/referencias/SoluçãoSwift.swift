struct Person: Equatable {
    let name: String
    let age: Int
}

func getPeople() -> [Person] {
    return [
        Person(name: "Alice", age: 29),
        Person(name: "Bob", age: 31)
    ]
}

func comparePeople() -> Bool {
    let p1 = Person(name: "Alice", age: 29)
    let p2 = Person(name: "Alice", age: 29)
    return p1 == p2  // should be true
}

print(comparePeople())
