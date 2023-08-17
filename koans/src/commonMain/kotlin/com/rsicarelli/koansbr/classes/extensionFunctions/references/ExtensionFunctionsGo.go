/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
)

type Pair struct {
	First  int
	Second int
}

type RationalNumber struct {
	Numerator   int
	Denominator int
}

func RInt(value int) RationalNumber {
	return RationalNumber{
		Numerator:   value,
		Denominator: 1,
	}
}

func RPair(pair Pair) RationalNumber {
	return RationalNumber{
		Numerator:   pair.First,
		Denominator: pair.Second,
	}
}

func main() {
	result1 := RInt(5)
	result2 := RPair(Pair{7, 3})

	fmt.Println(result1)
	fmt.Println(result2)
}
