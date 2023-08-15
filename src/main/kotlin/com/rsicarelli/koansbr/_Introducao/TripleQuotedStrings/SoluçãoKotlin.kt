const val question: String = "life, the universe, and everything"
const val answer: Int = 42

val tripleQuotedString: String =
    """
    #question = "$question"
    #answer = $answer
    """.trimMargin(
        marginPrefix = "#"
    )
