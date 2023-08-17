/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

import (
	"fmt"
)

func main() {
	err := checkAge(10)
	if err != nil {
		fmt.Println(err)
	}
}

// Em Go, o tipo de interface "error" é a forma convencional para expressar
//uma condição de erro, com o valor nil representando nenhum erro.
func failWithWrongAge(age int) error {
	return fmt.Errorf("Wrong age: %d", age)
}

func checkAge(age int) error {
	if age < 0 || age > 150 {
		return failWithWrongAge(age)
	}
	fmt.Printf("Congrats! Next year you'll be %d.\n", age+1)
	return nil
}
