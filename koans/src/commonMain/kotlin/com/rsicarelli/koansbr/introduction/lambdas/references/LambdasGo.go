/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

func ContainsEven(collection []int) bool {
	for _, item := range collection {
		if item%2 == 0 {
			return true
		}
	}
	return false
}
