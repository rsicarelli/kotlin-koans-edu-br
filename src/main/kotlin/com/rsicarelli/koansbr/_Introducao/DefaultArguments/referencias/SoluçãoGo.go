/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package referencias

import (
	"fmt"
	"strings"
)

func foo(name string, number *int, toUpperCase *bool) string {
	num := 42
	upper := false
	if number != nil {
		num = *number
	}
	if toUpperCase != nil {
		upper = *toUpperCase
	}

	if upper {
		name = strings.ToUpper(name)
	}
	return fmt.Sprintf("%s%d", name, num)
}

func useFoo() []string {
	return []string{
		foo("a", nil, nil),
		foo("b", func() *int { var i = 1; return &i }(), nil),
		foo("c", nil, func() *bool { var b = true; return &b }()),
		foo("d", func() *int { var i = 2; return &i }(), func() *bool { var b = true; return &b }()),
	}
}
