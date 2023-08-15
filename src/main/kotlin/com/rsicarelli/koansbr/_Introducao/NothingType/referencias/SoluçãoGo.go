/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 *
 */

package outros

import (
	"errors"
	"fmt"
)

func failWithWrongAge(age int) error {
	return errors.New("Wrong age: " + fmt.Sprint(age))
}

func checkAge(age int) {
	if age < 0 || age > 150 {
		panic(failWithWrongAge(age))
	} else {
		fmt.Printf("Congrats! Next year you'll be %v.\n", age+1)
	}
}

func main() {
	checkAge(10)
}
