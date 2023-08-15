/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

func failWithWrongAge(age: Int?) -> Never {
    fatalError("Wrong age: \(age ?? 0)")
}

func checkAge(age: Int?) {
    if age == nil || age! < 0 || age! > 150 {
        failWithWrongAge(age: age)
    } else {
        print("Congrats! Next year you'll be \(age! + 1).")
    }
}

checkAge(age: 10)
