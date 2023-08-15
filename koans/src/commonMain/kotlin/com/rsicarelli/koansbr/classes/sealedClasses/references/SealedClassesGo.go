/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

package references

type Expr interface{}

type Num struct {
	Value int
}

type Sum struct {
	Left, Right Expr
}

func Eval(expr Expr) int {
	switch e := expr.(type) {
	case Num:
		return e.Value
	case Sum:
		return Eval(e.Left) + Eval(e.Right)
	default:
		panic("Unknown Expr type")
	}
}
