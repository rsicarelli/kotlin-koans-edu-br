/*
* Swift não suporta named imports.
*/

class JavaRandom {
    func nextInt(value: Int) -> Int {
        return 0
    }
}

class KotlinRandom {
    func nextInt(value: Int) -> Int {
        return 0
    }
}

func useDifferentRandomClasses() -> String {
    return "Kotlin random: \(KotlinRandom().nextInt(value: 2)) Java random: \(JavaRandom().nextInt(value: 2))."
}

print(useDifferentRandomClasses())
