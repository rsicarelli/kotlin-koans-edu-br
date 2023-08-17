/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

import Foundation

let question = "life, the universe, and everything"
let answer = 42

let tripleQuotedString = """
    #question = "\(question)"
    #answer = \(answer)
""".trimmingCharacters(in: .whitespacesAndNewlines).replacingOccurrences(of: "#", with: "")
