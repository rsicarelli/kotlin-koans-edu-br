# Tipo "nenhum" (Nothing type)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Tipo "nenhum" (Nothing type)](#tipo-nenhum-nothing-type)
  * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [O papel especial de `Nothing`](#o-papel-especial-de-nothing)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
  * [Exercícios](#exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Nothing%20type/Task.kt)

Especifique o tipo de retorno `Nothing` para a função `failWithWrongAge`.

Sem especificar o tipo `Nothing`, a compilação da função `checkAge` falha, uma vez que o compilador pressupõe que age possa ser `null`.

## Caso de uso

`Nothing` representa um valor que nunca existe, e não é permitido ter um valor ou objeto desta classe porque seu construtor é privado.

`Nothing` serve para denotar funções que nunca devolvem um valor.

```kotlin
fun esperarPraSempre(): Nothing {
    while (true) {
        // Estou esperando...
    }
}   
```

### O papel especial de `Nothing`

Na [teoria dos tipos](https://pt.wikipedia.org/wiki/Teoria_dos_tipos), `Nothing` é considerado o "tipo mais baixo", ou seja,
é um subtipo de todos os outros tipos em Kotlin. Isso faz com que o valor de `Nothing` possa ser atribuído a variáveis de todos os tipos.

```kotlin
fun erro(mensagem: String): Nothing = throw IllegalStateException(mensagem)

fun encontrarSessao(idSessao: Int): Sessao =
    sessoesEmAndamento
        .firstOrNull { it.id == idSessao }
        ?: erro("Sessão não encontrada!")
```

Ainda que a função `erro()` devolva `Nothing`, a atribuição do seu resultado a uma variável de tipo `Sessao` é válida, pois `Nothing` atua
como subtipo de `Sessao`.

### Vantagens

- **Comunicação clara e direta**: uma função que retorna `Nothing` não tem a intenção de retornar um valor,
  removendo qualquer ambiguidade.
- **Flexibilidade**: se comporta como um "camaleão" no mundo dos tipos em Kotlin, tornando-se útil em diferentes cenários.
- **Economia de Recursos**: devido à inteligência do compilador, não gastamos memória alocando algo que nunca deveria existir.
- **Blindagem contra erros:** o `Nothing` deixa claro: _nunca vou retornar_. Esse tipo de garantia pode evitar surpresas
  desagradáveis em tempo de execução.

### Desvantagens

- **Adaptação necessária**: para quem está iniciando em Kotlin, o `Nothing` pode se apresentar como um conceito enigmático, requerendo uma
  curva de aprendizado.
- **Uso excessivo**: é possível cair na armadilha de usar o `Nothing` de maneira confusa e excessiva, complicando o
  código ao invés de simplificar.

## Analogia

Imagine um livro colorido que tenha uma capa com título, autores e editora. No entanto, ao abrir, todas as
páginas estão em branco. O livro existe, tem peso, tem formato, mas não tem conteúdo.

É assim que o `Nothing` funciona em Kotlin. Ele tem presença, possui representação, porém não contém um valor ou significado intrínseco.

No código, quando uma função retorna `Nothing`, é como se estivéssemos abrindo um livro esperando uma história, mas encontramos páginas
vazias.

---

## Exercícios

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. **➡️ [Tipo "nenhum" (Nothing type)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md
   )**
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)
