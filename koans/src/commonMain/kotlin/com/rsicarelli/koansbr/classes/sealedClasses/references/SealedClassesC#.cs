/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

public abstract class Expr { }

public sealed class Num : Expr {
    public int Value { get; }
    public Num(int value) => Value = value;
}

public sealed class Sum : Expr {
    public Expr Left { get; }
    public Expr Right { get; }
    public Sum(Expr left, Expr right) => (Left, Right) = (left, right);
}

public static int Eval(Expr expr) => expr switch {
    Num n => n.Value,
    Sum s => Eval(s.Left) + Eval(s.Right),
    _ => throw new ArgumentException("Unknown Expr type"),
};
