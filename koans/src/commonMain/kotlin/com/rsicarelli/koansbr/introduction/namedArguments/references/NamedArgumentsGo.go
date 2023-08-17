/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
	"strings"
)

// Go não suporta named arguments.

func joinOptions(options []string) string {
	return strings.Join(options, ", ")
}

func main() {
	options := []string{"Option 1", "Option 2", "Option 3"}
	result := joinOptions(options)
	fmt.Println(result)
}
