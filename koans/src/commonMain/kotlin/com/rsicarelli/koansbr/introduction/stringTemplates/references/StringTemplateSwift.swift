/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */
import Foundation

let month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

func getPattern(month: String) -> String {
    return "\\d{2} \(month) \\d{4}"
}

func main() {
    print(getPattern(month: month))
}

main()
