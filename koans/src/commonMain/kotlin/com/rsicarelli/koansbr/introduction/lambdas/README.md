# Lambdas

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Lambdas](#lambdas)
  * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [Lamba também é um tipo](#lamba-também-é-um-tipo)
    * [O que é `it`?](#o-que-é-it)
    * [Lambdas como último parâmetro](#lambdas-como-último-parâmetro)
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

Passe um lambda para a função [`any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html)para verificar se a coleção
contém um número par.

A função any, quando aplicada a uma coleção, recebe um predicado como argumento e retorna verdadeiro se pelo menos um elemento satisfizer a
condição.

## Caso de uso

[Lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) são funções anônimas que oferecem uma forma
elegante e poderosa de representar ações ou comportamentos em Kotlin.

O poder dos lambdas está na sua simplicidade. Elas permitem expressar uma ideia ou ação concisamente. Por exemplo, uma ação de somar dois
números pode ser representada assim:

```kotlin
val soma: (Int, Int) -> Int = { x, y -> x + y }
println(soma(5, 3))  // Saída: 8
```

- `(Int, Int) -> Int`: é a assinatura do lambda: recebe dois parâmetros `Int` e retorna outro `Int`.
- `{ x, y -> x + y }` define o bloco de execução. Os parâmetros são nomeados antes do símbolo `->`. Em seguida, vem a expressão que fornece o
  resultado do tipo esperado.

### Lamba também é um tipo

Em Kotlin os lambdas são tratados de forma flexível, podendo, por exemplo, ser passadas como argumentos,
retornadas por outras funções ou atribuídas a variáveis.

```kotlin
val formulaTriangulo: (Polígono) -> Double = { it.base * it.altura / 2 }
val formulaRetangulo: (Polígono) -> Double = { it.base * it.altura }

class Polígono(val base: Double, val altura: Double) {
    fun calcularArea(formula: (Polígono) -> Double): Double {
        return formula(this) //this representa "esta instancia"
    }
}

val triangulo = Polígono(base = 10.0, altura = 5.0)
val retângulo = Polígono(base = 8.0, altura = 6.0)

println("Área triangulo: ${triangulo.calcularArea(formulaTriangulo)}")
println("Área retângulo: ${retângulo.calcularArea(formulaRetangulo)}")
```

### O que é `it`?

Em Kotlin, quando lambdas possuem apenas um parâmetro, esse único parâmetro pode ser acessado implicitamente usando a
palavra-chave `it`, sem precisar declará-lo explicitamente.

```kotlin
val numeros = listOf(1, 2, 3, 4, 5)

val impares = numbers.filter { numero -> numero % 2 == 0 }
val pares = numbers.filter { it % 2 != 0 }
```

### Lambdas como último parâmetro

Se um lambda for o último parâmetro de uma função, é possível fechar os `)` e colocar o lambda fora dos parênteses usando `{}`.

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
  e [programação funcional](https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_funcional)**: lambdas permite a combinação de conceitos
  funcionais com programação imperativa
- **Flexibilidade**: o comportamento pode ser passado como argumento usando lambdas.
- **Integração Moderna**: Ótima compatibilidade com APIs 'kotlin-first', como
  o [Jetpack Compose](https://developer.android.com/jetpack/compose).

### Desvantagens

- **Desempenho**: Em alguns casos, lambdas podem ser menos eficientes, como captura intensiva de contexto.
- **Legibilidade**: O uso exagerado pode complicar a compreensão.
- **Depuração**: Lambdas podem gerar stacktraces complexas.
- **Retrocompatibilidade**: Em versões anteriores ao Java 8, a retrocompatibilidade é limitada.

### Testabilidade

- **Isolação**: é uma boa prática testar lambdas individualmente.
- **Verificação**: Garanta que lambdas produzam resultados corretos para as entradas dadas.
- **Cobertura**: Inclua tanto cenários comuns quanto "edge cases".
- **Simplicidade**: Mantenha lambdas focados e simples. Refatore se se estiverem muito complexos.

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
