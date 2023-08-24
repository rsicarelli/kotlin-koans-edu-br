public int Eval(Expr expr) {
    switch (expr) {
        case Num n:
            return n.Value;
        case Sum s:
            return Eval(s.Left) + Eval(s.Right);
        default:
            throw new ArgumentException("Unknown expression");
    }
}

interface Expr { }

class Num : Expr {
    public int Value { get; }

    public Num(int value) {
        Value = value;
    }
}

class Sum : Expr {
    public Expr Left { get; }
    public Expr Right { get; }

    public Sum(Expr left, Expr right) {
        Left = left;
        Right = right;
    }
}
