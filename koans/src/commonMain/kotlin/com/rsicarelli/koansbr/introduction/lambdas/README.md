# Introdução

<details open>
<summary>&nbsp;<b>Índice</b> (clique para esconder)</summary>

<p></p>

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. **➡️ [Lambdas](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md
   )**

</details>

---

## Lambdas

<details open>
<summary>&nbsp;<b>Tabela de conteúdo</b></summary>

<p></p>

<!-- TOC -->
* [Introdução](#introdução)
  * [Lambdas](#lambdas)
    * [Tarefa](#tarefa)
    * [Caso de uso](#caso-de-uso)
      * [Lambdas e os livros](#lambdas-e-os-livros)
      * [O que é `it`?](#o-que-é-it)
      * [Lambdas como último argumento](#lambdas-como-último-argumento)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
    * [Testabilidade](#testabilidade)
  * [Analogia](#analogia)
    * [Lambdas e o Canivete Suíço](#lambdas-e-o-canivete-suíço)
    * [Lambdas e RPG](#lambdas-e-rpg)
<!-- TOC -->

</details>

### Tarefa

[Kotlin Koans: Lambdas](https://play.kotlinlang.org/koans/Introduction/Lambdas/Task.kt)

Passe um lambda para a função [`any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html)
para verificar se a coleção contém um número par.
A função `any` recebe um predicado como argumento e retorna verdadeiro se pelo menos um elemento satisfizer o predicado.

[Lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) são funções anônimas que oferecem uma forma
elegante e poderosa de representar ações ou comportamentos em Kotlin.

O poder dos lambdas está na sua simplicidade. Elas permitem expressar uma ideia ou ação concisamente. Por exemplo, uma ação de somar dois
números pode ser representada assim:

```kotlin
val soma = { x, y -> x + y }
println(soma(5, 3))  // Saída: 8
```

> `{ x, y -> x + y }` representa um lambda que soma dois valores.

### Caso de uso

Outra grande vantagem é tratar funções como objetos, o que significa que podemos passar funções como argumentos:

```kotlin
fun aplicarOperacao(
    a: Int = 5,
    b: Int = 3,
    operacao: (Int, Int) -> Int,
): Int = operacao(a, b)
```

- `operacao:` É o nome da variável ou parâmetro que você está declarando, que neste contexto é um lambda.
- `(Int, Int)` Os tipos dos parâmetros que a lamba aceita. Neste caso, aceita dois parâmetros, ambos do tipo `Int`.
- `-> Int`: Define o tipo de retorno do lambda. Aqui, a função retorna um `Int`.

```kotlin
val soma = { x, y -> x + y }
val resultadoSoma = aplicarOperacao(operacao = soma)

val subtracao = { x, y -> x - y }
val resultadoSubtracao = aplicarOperacao(operacao = subtracao)

val divisao = { x, y -> x / y }
val resultadoSubtracao = aplicarOperacao(operacao = divisao)

val multiplicacao = { x, y -> x * y }
val resultadoMultiplicacao = aplicarOperacao(operacao = multiplicacao)
```

#### Lambdas e os livros

Imagine que lambdas são como marcadores de página em um livro. Eles indicam rapidamente onde você quer agir, sem ter que folhear todo o
livro.

```kotlin
val personagens = listOf("Frodo", "Sam", "Gandalf")
val hobbits = personagens.filter { it != "Gandalf" }
```

O lambda `{ it != "Gandalf" }` age como um marcador, destacando rapidamente os hobbits da lista.```

#### O que é `it`?

Em Kotlin, quando você trabalha com lambdas que têm apenas um parâmetro, esse único parâmetro pode ser acessado implicitamente usando a
palavra-chave `it`, sem precisar declará-lo explicitamente.

Imagine que você tem uma lista de números e quer filtrar apenas os pares. Usando lambdas, você poderia fazer algo assim:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { number -> number % 2 == 0 }
```

No exemplo acima, o lambda passado para a função filter tem um único parâmetro, `number`, que representa cada item da lista durante a
iteração.

Porém, como é comum ter lambdas com um único parâmetro, Kotlin oferece uma forma mais concisa de fazer o mesmo, usando o it:

```kotlin
val evenNumbers = numbers.filter { it % 2 == 0 }
```

Aqui, `it` refere-se automaticamente ao único parâmetro do lambda, que, neste caso, é cada item da lista `numbers`.

#### Lambdas como último argumento

Uma das características do Kotlin é a capacidade de mover lambdas para fora dos parênteses de uma função quando eles são o último
argumento. Isso torna o código mais legível, especialmente quando a expressão lambda é longa.

```kotlin
fun aplicarOperacao(a: Int, b: Int, operacao: (Int, Int) -> Int): Int = operacao(a, b)

//Forma convencional
aplicarOperacao(
    a = 5,
    b = 3,
    operacao = { x, y -> x + y }
)

//Simplificada, lambda foi pra "fora" dos ()
aplicarOperacao(a = 5, b = 3) { x, y -> x + y }
```

### Vantagens

- **Código conciso**: Lambdas simplificam a sintaxe das funções.
- **[Funções de ordem superior](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
  e [programação funcional](https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_funcional)**: lambdas permitem abstrações mais expressivas e
  utilizar conceitos funcionais com imperativo.
- **Flexibilidade**: o comportamento pode ser passado como argumento usando lambdas.
- **Integração Moderna**: Ótima compatibilidade com APIs 'kotlin-first', como
  o [Jetpack Compose](https://developer.android.com/jetpack/compose).

### Desvantagens

- **Desempenho**: Em alguns casos, lambdas podem ser menos eficientes, como captura intensiva de contexto.
- **Legibilidade**: O uso exagerado pode complicar a compreensão.
- **Depuração**: Lambdas podem gerar stacktraces complexas.
- **Retrocompatibilidade**: Limitada em versões superiores ao Java 8.

### Testabilidade

- **Isolação**: é uma boa prática testar lambdas individualmente.
- **Verificação**: Garanta que lambdas produzam resultados corretos para as entradas dadas.
- **Cobertura**: Inclua tanto cenários comuns quanto "edge cases".
- **Simplicidade**: Mantenha lambdas focados e simples. Refatore se tornarem-se muito complexos.

---

## Analogia

### Lambdas e o Canivete Suíço

- Ferramentas rápidas e versáteis para tarefas específicas.
- Assim como cada função do canivete, lambdas atendem a necessidades pontuais no código.
- Não precisam de nomes, assim como você não nomeia cada uso do canivete.

### Lambdas e RPG

- Uma "magia" que pode ser rapidamente adaptada conforme a situação.
- Enfrentando um desafio específico? Crie uma magia no momento, sem ter que procurar na sua lista pré-definida de feitiços.
- Lambdas oferecem essa mesma adaptabilidade no código, permitindo soluções rápidas e específicas.
