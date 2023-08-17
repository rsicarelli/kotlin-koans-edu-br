/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

import Foundation

func main() {
    do {
        try checkAge(10)
    } catch let error as NSError {
        print(error.localizedDescription)
    }
}

enum CustomError: Error {
    case wrongAge(Int)
}

func failWithWrongAge(age: Int) throws -> Never {
    throw CustomError.wrongAge(age)
}

func checkAge(age: Int?) throws {
    guard let age = age, age >= 0, age <= 150 else {
        try failWithWrongAge(age: age ?? 0)
        return
    }
    print("Congrats! Next year you'll be \(age + 1).")
}

main()
