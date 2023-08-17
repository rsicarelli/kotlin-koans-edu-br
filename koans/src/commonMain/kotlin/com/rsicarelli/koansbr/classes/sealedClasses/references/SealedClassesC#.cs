/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

public abstract class Expr {}

public class Num : Expr {
    public int Value { get; }
    public Num(int value) => Value = value;
}

public class Sum : Expr {
    public Expr Left { get; }
    public Expr Right { get; }
    public Sum(Expr left, Expr right) {
        Left = left;
        Right = right;
    }
}

// Evaluation function
public static int Eval(Expr expr) {
    switch (expr) {
        case Num n:
            return n.Value;
        case Sum s:
            return Eval(s.Left) + Eval(s.Right);
        default:
            throw new InvalidOperationException("Unknown Expr type");
    }
}
