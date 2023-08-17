/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
)

// Go não suporta default arguments.

func foo(name string, options ...interface{}) string {
	number := 42
	toUpperCase := false
	if len(options) > 0 {
		number = options[0].(int)
	}
	if len(options) > 1 {
		toUpperCase = options[1].(bool)
	}
	if toUpperCase {
		return name + fmt.Sprintf("%d", number)
	}
	return name + fmt.Sprintf("%d", number)
}

func useFoo() []string {
	result := make([]string, 0)
	result = append(result, foo("a"))
	result = append(result, foo("b", 1))
	result = append(result, foo("c", false))
	result = append(result, foo("d", 2, true))
	return result
}

func main() {
	result := useFoo()
	fmt.Println(result)
}
