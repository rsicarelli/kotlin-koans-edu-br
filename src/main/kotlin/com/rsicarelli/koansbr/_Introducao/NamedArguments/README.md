# Argumentos nomeados

Argumentos nomeados são uma característica do Kotlin que permite especificar o nome do argumento ao chamar uma função. Isso pode tornar seu
código mais legível e autoexplicativo.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.kt

Faça com que a função `joinOptions()` retorne a lista em formato [JSON](https://pt.wikipedia.org/wiki/JSON) (por exemplo, `[a, b, c]`)
especificando apenas dois argumentos.

Você pode utilizar a função [`joinToString`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/join-to-string.html) disponível
na [stdlib](https://kotlinlang.org/api/latest/jvm/stdlib/):

```kotlin
fun joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    /* ... */
): String
```

## Caso de uso

Você pode chamar essa função passando argumentos na ordem correta:

```kotlin
joinToString(
    ", ",
    "prefixo",
    "sufixo",
): String
```

Mas ao usar argumentos nomeados, você pode especificar os nomes dos argumentos diretamente na chamada:

```kotlin
joinToString(
    separator = ", ",
    prefix = "prefixo",
    postfix = "sufixo",
): String
```

Com argumentos nomeados, você não precisa se lembrar da ordem dos argumentos. Você poderia até mesmo mudar a ordem, desde que você
especifique o nome:

```kotlin
joinToString(
    postfix = "sufixo",
    separator = ", ",
    prefix = "prefixo",
): String
```

### Vantagens

- **Legibilidade de código**: ao chamar uma função com vários argumentos, especialmente se eles são do mesmo tipo, pode ser difícil entender
  a que cada argumento se refere. Adicionar nomes aos seus argumentos os tornam explícitos, elevando a coesão do seu código e evitando
  problemas futuros.
- **Elimina a necessidade de [sobrecarga de funções](https://pt.wikipedia.org/wiki/Sobrecarga_de_fun%C3%A7%C3%A3o)**: no Java, você
  precisaria criar várias versões de uma função para lidar com diferentes
  números de argumentos. Em Kotlin, você pode usar argumentos nomeados combinados com argumentos padrão para evitar essa sobrecarga.
- **Permite a reordenação de argumentos:** Com argumentos nomeados, você não precisa se lembrar da ordem dos argumentos ao chamar uma
  função; você pode especificar os argumentos na ordem que quiser.

### Desvantagens

- **Compatibilidade entre versões:** Se o nome de um argumento é alterado na função, qualquer código que chame essa função usando um
  argumento nomeado precisará ser atualizado. Isso pode tornar as mudanças no código mais problemáticas do que se estivesse usando
  argumentos posicionais.
- **Verbosidade:** Em alguns casos, o uso de argumentos nomeados pode tornar o código mais verboso, especialmente se o nome do argumento for
  longo.

## Notas

- Em inglês, termo utilizado é `Named Arguments`.

## Dicas

- Você pode criar uma instância de `List` utilizando a
  função [`listOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html)
- Posicione o cursor sobre uma função, aperte `Alt + Enter` e selecione `Adicionar nomes aos argumentos`
- Pode usar o `Alt + Enter` também para `Colocar os argumentos em linhas separadas`
