let question = "life, the universe, and everything"
let answer = 42

let tripleQuotedString = """
  #question = "\(question)"
  #answer = \(answer)
""".trimmingCharacters(in: .whitespacesAndNewlines)
