### Índice:

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. 📖 **[Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)**
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)

---
### Tarefa
[Kotlin Koans: Triple quoted Strings](https://play.kotlinlang.org/koans/Introduction/Triple-quoted%20strings/Task.kt)

Substitua a chamada `trimIndent` pela chamada `trimMargin` tomando `#` como valor de prefixo para que a string resultante não contenha o
caractere de prefixo.

Você pode usar as funções
[`trimIndent`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-indent.html)
e [`trimMargin`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-margin.html)
para formatar ‘strings’ de múltiplas linhas com aspas triplas conforme o código ao redor.
---

# Strings com três aspas (Triple-quoted strings)

Em Kotlin, as [aspas triplas](https://kotlinlang.org/docs/strings.html#multiline-strings) (`multiline strings`) são uma ferramenta poderosa
para lidar com Strings que contêm várias linhas e caracteres especiais sem a necessidade de escape. Essa abordagem melhora a legibilidade do
código e facilita a manipulação de textos extensos ou formatados de maneira complexa.

Saiba mais sobre os [diferentes literais de string e modelos de string](https://kotlinlang.org/docs/strings.html#string-literals)
em Kotlin.

## Caso de uso

Uma string de aspas triplas é delimitada por três aspas duplas consecutivas (`"""`). Isso permite que você crie strings multilinha de forma
simples, como mostrado no exemplo a seguir:

```kotlin
val texto = """
    Esta é uma string que contém
    várias linhas
    sem a necessidade de caracteres de escape.
"""
```

Dentro das aspas triplas, o conteúdo é tratado como texto normal, o que significa que caracteres como `\n` (nova linha) e `\t` (tabulação)
não são interpretados como caracteres de controle.

#### Vantagens

- **Strings Multilinha Simples**: As aspas triplas permitem criar strings multilinha com facilidade, tornando mais prático trabalhar com
  textos longos ou com formatações específicas.
- **Escape de caracteres não é necessário**: ao usar aspas triplas, você não precisa escapar caracteres especiais, melhorando a clareza e a
  legibilidade do código.
- **Templates de Strings**: As aspas triplas suportam templates de strings, facilitando a incorporação de valores dinâmicos em textos,
  tornando a manipulação de strings mais flexível.

#### Desvantagens:

- **Espaço em branco indesejado**: Um desafio comum ao usar aspas triplas é a possibilidade de incluir espaços em branco indesejados na
  string. Isso pode ser evitado utilizando funções como `trimMargin()` e `trimIndent()` para remover esses espaços extras.
- **Menos suporte em algumas IDEs e ferramentas de edição de texto**: É importante notar que algumas IDEs e ferramentas de edição de texto
  podem apresentar dificuldades na coloração de sintaxe, formatação automática ou em outros recursos ao trabalhar com strings de aspas
  triplas.
- **Problemas de desempenho**: embora as aspas triplas sejam úteis, em algumas situações, como loops intensivos, seu uso excessivo pode
  levar a problemas de desempenho.

### Analogia

#### Aspas triplas e um palco amplo de teatro

Imagine que você está atuando em um palco teatral. Em uma peça convencional, você tem que se limitar a um pequeno espaço no palco, onde cada
movimento precisa ser calculado. Isso pode ser restritivo e complicado, especialmente quando você precisa expressar emoções
fortes ou executar movimentos complexos.

Agora, considere as aspas triplas em Kotlin como um palco grande, amplo. Quando você está nesse tipo de palco, você tem liberdade para se
mover, expressar-se e interagir de maneira natural. Você não precisa se preocupar com limitações rígidas de espaço ou movimento.

Da mesma forma, as aspas triplas permitem que você crie strings sem se preocupar com a formatação precisa ou com a necessidade de escapar de
caracteres especiais. Você pode escrever com fluidez, dividindo suas ideias em várias linhas, como se estivesse usando o espaço amplo do
palco para se expressar.
