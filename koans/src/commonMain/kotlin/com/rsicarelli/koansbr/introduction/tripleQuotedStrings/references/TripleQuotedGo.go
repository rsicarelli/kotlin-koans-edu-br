/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
	"strings"
)

func getTripleQuotedString() string {
	question := "life, the universe, and everything"
	answer := 42

	tripleQuotedString := `
	#question = "` + question + `"
	#answer = ` + fmt.Sprintf("%d", answer) + `
	`
	return strings.ReplaceAll(tripleQuotedString, "#", "")
}

func main() {
	fmt.Println(getTripleQuotedString())
}
