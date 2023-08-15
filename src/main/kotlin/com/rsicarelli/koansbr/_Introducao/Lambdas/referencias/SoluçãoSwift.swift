func containsEven(collection: [Int]) -> Bool {
    return collection.contains(where: { $0 % 2 == 0 })
}
