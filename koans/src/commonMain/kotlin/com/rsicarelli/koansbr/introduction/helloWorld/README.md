# Olá, mundo! (Hello, world!)

<details>
<summary>&nbsp;<b>Conteúdo</b></summary>

<p></p>

<!-- TOC -->
* [Olá, mundo! (Hello, world!)](#olá-mundo-hello-world)
  * [🔗 Tarefa](#-tarefa)
  * [Casos de uso](#casos-de-uso)
    * [O que é uma função em Kotlin?](#o-que-é-uma-função-em-kotlin)
    * [Função simples](#função-simples)
    * [Funções em uma linha](#funções-em-uma-linha)
    * [Função sem Retorno](#função-sem-retorno)
      * [O tipo de unidade `Unit`](#o-tipo-de-unidade-unit)
    * [Lidando com múltiplos argumentos usando `vararg`](#lidando-com-múltiplos-argumentos-usando-vararg)
    * [Declarando variáveis](#declarando-variáveis)
  * [Tipos em Kotlin](#tipos-em-kotlin)
  * [Índice de exercícios](#índice-de-exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt)

Altere o código para que a função `start` retorne a string `"OK"`.

Nas tarefas do Kotlin Koans, a função `TODO()` lançará uma exceção.
Para concluir o Kotlin Koans, você precisa substituir essa invocação de função por um código significativo de acordo com o problema.

---

## Casos de uso

### O que é uma função em Kotlin?

Funções em Kotlin são blocos de código que realizam tarefas específicas. Elas são partes fundamentais da linguagem, nos permitindo
organizar, reutilizar e executar ações de forma eficiente.

Uma função em Kotlin tem a seguinte estrutura:

```kotlin
fun nomeDaFuncao(
    argumento1: Tipo,
    argumento2: Tipo,
): TipoDeRetorno {
    return valorDeRetorno
}
```

- `fun`: a palavra-chave e reservada, utilizada para declarar o início de uma função.
- `nomeDaFuncao`: um nome significativo e específico à função.
- `(argumento1: Tipo, argumento2: Tipo)` define os argumentos que a função espera receber. Cada argumento tem um nome e um tipo.
- `: TipoDeRetorno` tipo de valor a função retornará após ser executada.
- `{}` o corpo da função, onde o código é escrito. Aqui, você define as ações que a função executará.

### Função simples

A seguir temos uma função simples que soma dois números inteiros e retorna o resultado

```kotlin
fun somar(a: Int, b: Int): Int {
    val resultado = a + b
    return resultado
}

val resultadoSoma = somar(3, 5)
println(resultadoSoma) // Resultado: 8
```

### Funções em uma linha

Em Kotlin, quando uma função possui apenas uma expressão após o símbolo `=`, e o tipo de retorno está especificado ou implícito, o
compilador entende que
o resultado dessa expressão é o valor de retorno da função.

Isso nos possibilita remover o corpo `{}` e utilizar como expressão `=`

```kotlin
fun dobrar(numero: Int): Int = numero * 2

val numeroDobrado = dobrar(7)
println(numeroDobrado) // Resultado: 14
```

### Função sem Retorno

Se uma função não tiver um valor de retorno explícito, seu tipo de retorno será inferido como `Unit`, o equivalente ao `void` em outras
linguagens

#### O tipo de unidade `Unit`

O tipo `Unit` em Kotlin é utilizado para representar a ausência de valor de retorno de uma função.

É como dizer "essa função não retorna nada". Isso é similar ao conceito de `void `em algumas outras linguagens de programação.

A seguir, todas as expressões são válidas pelo compilador, que conseguir inferir o tipo pelo resultado da expressão.

```kotlin
fun exibirMensagem(texto: String): Unit {
    println(texto)
}
```

```kotlin
fun exibirMensagem(texto: String): Unit = println(texto)
```

```kotlin
fun exibirMensagem(texto: String) {
    println(texto)
}
```

```kotlin
fun exibirMensagem(texto: String) = println(texto)
```

### Lidando com múltiplos argumentos usando `vararg`

O `vararg` em Kotlin permite passar uma quantidade variável de argumentos para uma função

```kotlin
fun imprimirItens(vararg itens: String) {
    for (item in itens) {
        println(item)
    }
}

imprimirItens("Paçoca", "Cajú", "Açaí")
```

### Declarando variáveis

Em Kotlin, temos duas maneiras principais de declarar variáveis: usando `val` e `var`.

1. `val` valor final, que não pode ser alterado
    ```kotlin
    val tituloDoLivro = "A Jornada Dev"
    // tituloDoLivro = "Outro Título" //impossível
    ```
2. `var` variável, que pode ser alterado
    ```kotlin
    var paginaDeRascunho = "Minha ideia"
    paginaDeRascunho = "Uma ideia diferente" // permitido
    ```

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

---

## Índice de exercícios

1. **➡️ [Olá, mundo! (Hello, world!)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md
   )**
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)
