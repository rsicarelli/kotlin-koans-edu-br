/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package main

import (
	"fmt"
)

var month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

func getPattern() string {
	return "\\d{2} " + month + " \\d{4}"
}

func main() {
	fmt.Println(getPattern())
}
