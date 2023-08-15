## Strings com aspas triplas

Em Kotlin, [aspas triplas](https://kotlinlang.org/docs/strings.html#multiline-strings) (`multiline strings`) são usadas para
delimitar `String`s que contém várias linhas e caracteres especiais sem necessidade de escape.

Saiba mais sobre os [diferentes literais de string e modelos de string](https://kotlinlang.org/docs/strings.html#string-literals)
em Kotlin.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Triple-quoted%20strings/Task.kt

Substitua a chamada `trimIndent` pela chamada `trimMargin` tomando `#` como valor de prefixo para que a string resultante não contenha o
caractere de prefixo.

Você pode usar as funções
[`trimIndent`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-indent.html)
e [`trimMargin`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-margin.html)
para formatar ‘strings’ de múltiplas linhas com aspas triplas conforme o código ao redor.

## Caso de uso

Uma string de aspas triplas é definida por três aspas duplas consecutivas `"""`, exemplo:

### Aspas triplas

```kotlin
val texto = """
    Esta é uma string que contém
    várias linhas
    sem a necessidade de caracteres de escape.
"""
```

O conteúdo dentro das aspas triplas são tratados como caracteres de texto normal.

Caracteres como `\n` (newlines) e `\t` (tabs) não são interpretados como caracteres de controle em strings de aspas triplas.

#### Vantagens

- **Strings multilinha sem problema**: A maior vantagem das aspas triplas é que permitem criar facilmente strings multilinha, o que pode ser
  muito útil ao trabalhar com textos grandes e formatações específicas.
- **Sem necessidade de escape de caracteres**: Em uma string com aspas triplas, não é necessário escapar os caracteres especiais, o que
  simplifica muito a leitura do código.
- **Incorporação de templates de strings**: As aspas triplas permitem a utilização de templates de strings, o que torna a manipulação dessas
  strings muito mais simples e flexível.

#### Desvantagens:

- **Espaço em branco indesejado**: Um problema comum ao utilizar aspas triplas surge quando inadvertidamente incorporamos espaços em branco
  indesejados na ‘string’. Isso pode ser evitado através da utilização de funções como `trimMargin()` e `trimIndent()`.
- **Menos suporte em algumas IDEs e ferramentas de edição de texto**: algumas IDEs e ferramentas de edição de texto podem ter dificuldades
  com a coloração de sintaxe, formatação automática, ou outros recursos ao trabalhar com ‘strings’ de aspas triplas.
- **Problemas de desempenho**: Em algumas situações, o uso de ‘strings’ de aspas triplas pode levar a problemas de desempenho, especialmente
  quando usadas em ‘loops’ ou em abundância.

