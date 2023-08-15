/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

/*
* Go não suporta classes aninhadas ou sobrecarga de métodos, então desta forma não seria possível ter uma tradução direta.
 */

type RationalNumber struct {
	numerator   int
	denominator int
}

func R(i int) RationalNumber {
	return RationalNumber{i, 1}
}

func R2(a int, b int) RationalNumber {
	return RationalNumber{a, b}
}
