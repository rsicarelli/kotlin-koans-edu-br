protocol Expr {}

struct Num: Expr {
    let value: Int
}

struct Sum: Expr {
    let left, right: Expr
}

func eval(expr: Expr) -> Int {
    if let num = expr as? Num {
        return num.value
    } else if let sum = expr as? Sum {
        return eval(expr: sum.left) + eval(expr: sum.right)
    } else {
        fatalError("Unknown expression")
    }
}
