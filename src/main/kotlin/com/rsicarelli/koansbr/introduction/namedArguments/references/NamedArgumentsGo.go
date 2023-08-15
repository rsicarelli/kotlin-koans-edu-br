/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"strings"
)

func joinOptions(options []string) string {
	return "[" + strings.Join(options, ", ") + "]"
}
