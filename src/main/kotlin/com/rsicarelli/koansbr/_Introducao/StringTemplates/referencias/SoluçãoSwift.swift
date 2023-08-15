let month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

func getPattern() -> String {
    return "\\d{2} \(month) \\d{4}"
}
