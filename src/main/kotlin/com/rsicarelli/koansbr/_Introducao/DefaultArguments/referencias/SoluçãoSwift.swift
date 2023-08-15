func foo(_ name: String, number: Int = 42, toUpperCase: Bool = false) -> String {
    return (toUpperCase ? name.uppercased() : name) + String(number)
}

func useFoo() -> [String] {
    return [
        foo("a"),
        foo("b", number: 1),
        foo("c", toUpperCase: true),
        foo("d", number: 2, toUpperCase: true)
    ]
}
