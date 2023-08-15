/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package outros

import (
	"fmt"
	"strings"
)

func main() {
	question := "life, the universe, and everything"
	answer := 42

	tripleQuotedString := fmt.Sprintf(`
    #question = "%v"
    #answer = %v
    `, question, answer)

	tripleQuotedString = strings.TrimSpace(tripleQuotedString)
	fmt.Println(tripleQuotedString)
}
