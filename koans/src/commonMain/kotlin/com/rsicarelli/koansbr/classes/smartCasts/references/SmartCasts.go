/*
 * SPDX-License-Identifier: MIT
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
	switch v := expr.(type) {
	case Num:
		return v.Value
	case Sum:
		return Eval(v.Left) + Eval(v.Right)
	default:
		panic("Unknown expression")
	}
}
