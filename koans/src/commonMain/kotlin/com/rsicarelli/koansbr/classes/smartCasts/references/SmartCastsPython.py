class Expr:
    pass


class Num(Expr):
    def __init__(self, value: int):
        super().__init__()
        self.value = value


class Sum(Expr):
    def __init__(self, left: Expr, right: Expr):
        super().__init__()
        self.left = left
        self.right = right


def evaluate_expr(expr: Expr) -> int:
    if isinstance(expr, Num):
        return expr.value
    elif isinstance(expr, Sum):
        return evaluate_expr(expr.left) + evaluate_expr(expr.right)
    else:
        raise ValueError("Unknown expression")
