fun joinOptions(options: List<String>): String =
    options.joinToString(
        prefix = "[",
        postfix = "]"
    )
