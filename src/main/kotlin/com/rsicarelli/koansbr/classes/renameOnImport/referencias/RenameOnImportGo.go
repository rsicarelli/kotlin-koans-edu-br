/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package references

/*
* Go não tem uma tradução direta para named imports.
 */
import "fmt"

type JavaRandom struct{}

func (j JavaRandom) NextInt(value int) int {
	return value
}

type KotlinRandom struct{}

func (k KotlinRandom) NextInt(value int) int {
	return value
}

type KRandom struct {
}

func (r KRandom) NextInt(i int) any {
	return KotlinRandom{}.NextInt(i)
}

type JRandom struct {
}

func (r JRandom) NextInt(i int) any {
	return JavaRandom{}.NextInt(i)
}

func useDifferentRandomClasses() string {
	return fmt.Sprintf("Kotlin random: %d Java random: %d.",
		KRandom{}.NextInt(2),
		JRandom{}.NextInt(2))
}

func main() {
	fmt.Println(useDifferentRandomClasses())
}
