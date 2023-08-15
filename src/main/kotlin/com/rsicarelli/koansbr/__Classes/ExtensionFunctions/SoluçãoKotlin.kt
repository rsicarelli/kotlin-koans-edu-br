fun Int.r(): RationalNumber =
    RationalNumber(
        numerator = this,
        denominator = 1
    )

fun Pair<Int, Int>.r(): RationalNumber =
    RationalNumber(
        numerator = first,
        denominator = second
    )

data class RationalNumber(
    val numerator: Int,
    val denominator: Int,
)
