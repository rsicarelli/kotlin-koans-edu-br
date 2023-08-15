fun evalCast(expr: ExprCast): Int =
    when (expr) {
        is NumCast -> expr.value
        is SumCast -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface ExprCast
class NumCast(val value: Int) : ExprCast
class SumCast(val left: Expr, val right: Expr) : ExprCast
