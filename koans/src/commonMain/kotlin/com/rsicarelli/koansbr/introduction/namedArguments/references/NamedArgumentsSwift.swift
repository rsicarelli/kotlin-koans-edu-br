/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
import Foundation

// Swift suporta named arguments usando a sintaxe "options: options".

func joinOptions(options: [String]) -> String {
    return options.joined(separator: ", ")
}

let options = ["Option 1", "Option 2", "Option 3"]
let result = joinOptions(options: options)
print(result)

