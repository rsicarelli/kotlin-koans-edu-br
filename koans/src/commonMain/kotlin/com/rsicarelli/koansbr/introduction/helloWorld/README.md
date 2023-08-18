## Introdução
### Índice:

1. ➡️ **[Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)**
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)

---

### Tarefa 
[Kotlin Koan: Hello World!](https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt)

Altere o código para que a função `start` retorne a string `"OK"`.

Nas tarefas do Kotlin Koans, a função `TODO()` lançará uma exceção.
Para concluir o Kotlin Koans, você precisa substituir essa invocação de função por um código significativo de acordo com o problema.

---

## Olá, mundo! (Hello, world!)

Ao abrir um novo livro, sentimos a expectativa do que está por vir em suas páginas. Esta sensação de descoberta é semelhante ao mergulho em
uma nova linguagem de programação.

Imagine Kotlin como um livro de histórias. Dentro desse livro, temos diversos capítulos que narram diferentes partes da trama. Em Kotlin, as
funções atuam como esses capítulos, contando suas próprias histórias ou tarefas.

```kotlin
fun nomeDoCapitulo(
    protagonista1: Descricao,
    coadjuvante: Descricao,
): Desfecho {
    // narração do capítulo
}
```

- **`fun`**: Assim como identificamos um novo capítulo ao virar a página, em Kotlin, a palavra "fun" nos indica que estamos prestes a
  começar uma nova "narrativa" ou função.

- **`nomeDoCapitulo`**: Cada capítulo de um livro tem um título, que nos dá uma ideia sobre o que ele irá tratar. Da mesma forma, o nome da
  função nos dá pistas sobre seu propósito ou ação principal.

- **`(protagonista1: Descrição, coadjuvante: Descrição)`**: Um capítulo tem personagens, e cada personagem têm um papel importante na
  história. Em Kotlin, os argumentos da função são como esses personagens. Eles têm nomes e características (ou tipos), que nos informam sua
  relevância no "capítulo".

- **`: Desfecho`**: Ao final de um capítulo, chegamos a uma conclusão ou reviravolta. Em Kotlin, essa é a "conclusão" da nossa função,
  conhecida como tipo de retorno (return type), indicando o que esperar ao final da execução.

- **`{}`**: Este é o conteúdo do capítulo, onde os eventos se desenrolam. Em Kotlin, é dentro dessas chaves que colocamos a narrativa
  principal da função, o código que ela executará.

### Casos de uso

#### Funções em uma linha

Em um livro, certos capítulos podem ter um resumo ou uma frase destacada para facilitar a compreensão. Kotlin permite expressar funções de
forma concisa, quase como um resumo rápido.

No exemplo a seguir, as chaves `{}` foram removidas, sendo substituída para atribuição `=`.

```kotlin
fun resumoDoCapitulo(título: String, definição: String): String = "$título: $definição"

val resumo = resumoDoCapitulo("Biblioteca", "Um lugar para guardar livros.")
println(resumo)  // Saída: Biblioteca: Um lugar para guardar livros.
```

#### Tipo de retorno inferido

É comum calcular o tamanho de um livro pelo número de palavras. Em Kotlin, se uma função retorna "algo direto", substituindo o `{}`, o tipo
de retorno pode ser inferido pelo compilador.

```kotlin
fun calcularTamanhoDoLivro(palavras: String) = palavras.length

val tamanho = calcularTamanhoDoLivro("Era uma vez...")
println(tamanho)  // Saída: 14
```

#### Funções com Varargs

Em uma estante de livros, você pode ter uma coleção de contos, onde cada conto é uma história única, mas todos estão contidos em um único
volume. Da mesma forma, em Kotlin, existe um conceito chamado `varargs`, que permite que uma função aceite um número variável de argumentos.

```kotlin
fun contosNoLivro(vararg contos: String) {
    for (conto in contos) {
        println("Nome do conto: $conto")
    }
}

contosNoLivro("O Aprendiz de Feiticeiro", "A Princesa e a Ervilha", "O Cavaleiro e o Dragão")
```

### O tipo de unidade Unit

Em Kotlin, [`Unit`](https://kotlinlang.org/docs/functions.html#unit-returning-functions) é o equivalente ao `void` de outras linguagens de
programação, como Java ou C++. No entanto, há uma diferença conceitual importante entre eles: enquanto `void` literalmente significa "sem
valor", `Unit` é um tipo real com um único valor (também chamado de `Unit`).

```kotlin
fun semRetorno(): Unit = Unit
fun semRetorno(): Unit = { }
fun semRetorno() = Unit
fun semRetorno() = { }

val unidade: Unit = semRetorno()
print(unidade) //Saída: Unit
```

### Declarando variáveis

Em Kotlin, temos duas maneiras principais de declarar variáveis: usando `val` e `var`.

1. `val` de "value" ou valor

Quando declaramos uma variável usando `val`, ela só pode receber um valor uma única vez. Depois de definido, esse valor não pode ser
alterado.
Em outras palavras, essa variável é **imutável**.

```kotlin
val tituloDoLivro = "A Jornada Dev"
// tituloDoLivro = "Outro Título" -> Isto causará um erro, porque não podemos mudar o valor de uma variável 'val' após atribuí-la.
```

2. `var` "variable" ou variável

Ao usar `var` na declaração de uma variável, ela pode ter seu valor modificado diversas vezes conforme necessário.

```kotlin
var paginaDeRascunho = "Isto é um esboço do capítulo 1."
paginaDeRascunho = "Isto é um esboço revisado do capítulo 1." // Nenhum erro aqui, porque podemos mudar o valor de uma variável 'var'.
```

---

## Tipos em Kotlin

https://kotlinlang.org/docs/kotlin-tour-basic-types.html

Em Kotlin, assim como em outras linguagens de programação, os tipos definem a natureza de um valor e determinam as operações que podem ser
realizadas com esse valor.

```kotlin
// ExemplosTipos.kt

// Int: Representa números inteiros.
val anoAtual: Int = 2023

// Double: número em ponto flutuante de precisão dupla
val peso: Double = 1.534776

// Float: ponto flutuante de precisão simples
val altura: Float = 1.82F

// Long: Para números inteiros grandes.
val populacaoMundial: Long = 7800000000L

// Byte: Um tipo de número inteiro menor.
val idade: Byte = 25

// Char: Representa um único caractere.
val inicial: Char = 'K'

// Boolean: Valores verdadeiros ou falsos.
val estudandoKotlin: Boolean = true

// String: Sequência de caracteres.
val nome: String = "Chico"

// List: Lista de elementos.
val livros: List<String> = listOf("Kotlin para Iniciantes", "Programação Funcional")

// Set: Coleção de elementos únicos, sem repetição.
val cores: Set<String> = setOf("Vermelho", "Azul", "Verde")

// Map: Coleção de pares chave-valor.
val dicionario: Map<String, String> = mapOf("Kotlin" to "Uma linguagem de programação", "Lua" to "Outra linguagem de programação")

// Sequence: Sequência de elementos, ideal para coleções grandes ou cálculos mais pesados.
val numeros: Sequence<Int> = sequenceOf(1, 2, 3, 4, 5)

// Array: Similar a List, mas de tamanho fixo.
val diasDaSemana: Array<String> = arrayOf("Segunda", "Terça", "Quarta")

// Byte: representa um valor integral de 8 bits, com valor entre -128 e 127.
val exemploByte: Byte = 127

// UByte: um byte não assinado que representa um valor integral entre 0 e 255.
val uByteExemplo: UByte = 255u

// UShort: um short não assinado que representa um valor integral entre 0 e 65,535.
val uShortExemplo: UShort = 65535u

// UInt: um int não assinado que representa um valor integral entre 0 e 4,294,967,295.
val uIntExemplo: UInt = 4294967295u

// ULong: um long não assinado que representa um valor integral entre 0 e 18,446,744,073,709,551,615.
val uLongExemplo: ULong = 18446744073709551615uL
```
