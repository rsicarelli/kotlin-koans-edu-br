# Lambdas

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->

* [Lambdas](#lambdas)
    * [🔗 Tarefa](#-tarefa)
    * [Caso de uso](#caso-de-uso)
        * [O que são lambdas?](#o-que-são-lambdas)
        * [Lambdas e os livros](#lambdas-e-os-livros)
        * [Lamba também é um tipo](#lamba-também-é-um-tipo)
        * [O que é `it`?](#o-que-é-it)
        * [Lambdas como último argumento](#lambdas-como-último-argumento)
        * [Vantagens](#vantagens)
        * [Desvantagens](#desvantagens)
        * [Testabilidade](#testabilidade)
    * [Analogia](#analogia)
        * [Lambdas e o Canivete Suíço](#lambdas-e-o-canivete-suíço)
        * [Lambdas e RPG](#lambdas-e-rpg)
    * [Exercícios](#exercícios)

<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Lambdas/Task.kt)

Passe um lambda para a função [`any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html)
para verificar se a coleção contém um número par.
A função `any` recebe um predicado como argumento e retorna verdadeiro se pelo menos um elemento satisfizer o predicado.

## Caso de uso

### O que são lambdas?

[Lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) são funções anônimas que oferecem uma forma
elegante e poderosa de representar ações ou comportamentos em Kotlin.

O poder dos lambdas está na sua simplicidade. Elas permitem expressar uma ideia ou ação concisamente. Por exemplo, uma ação de somar dois
números pode ser representada assim:

```kotlin
val soma = { x, y -> x + y }
println(soma(5, 3))  // Saída: 8
```

> `{ x, y -> x + y }` representa um lambda que soma dois valores.

### Lamba também é um tipo

Outra grande vantagem é tratar funções como objetos, o que significa que podemos passar funções como argumentos:

```kotlin
fun aplicarOperacao(
    a: Int = 5,
    b: Int = 3,
    operacao: (Int, Int) -> Int,
): Int = operacao(a, b)
```

- `operacao:` É o nome da variável ou parâmetro, que neste contexto é um lambda.
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

### O que é `it`?

Em Kotlin, quando lambdas possuem apenas um parâmetro, esse único parâmetro pode ser acessado implicitamente usando a
palavra-chave `it`, sem precisar declará-lo explicitamente.

```kotlin
val numeros = listOf(1, 2, 3, 4, 5)
val numerosImpares = numbers.filter { numbero -> numbero % 2 == 0 }
val numerosPares = numbers.filter { it % 2 != 0 }
```

### Lambdas como último argumento

Se um lambda for o último argumento de uma função, podemos fechar os `)` e acessar a lambda do terceiro parâmetro abrindo um par de`{}`

```kotlin
fun aplicarOperacao(a: Int, b: Int, operacao: (Int, Int) -> Int): Int = operacao(a, b)

aplicarOperacao(
    a = 5,
    b = 3
) { x, y ->
    x + y
}
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

### Lambdas e RPG

- Uma "magia" que pode ser rapidamente adaptada conforme a situação.
- Enfrentando um desafio específico? Crie uma magia no momento, sem ter que procurar na sua lista pré-definida de feitiços.

---

## Exercícios

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
