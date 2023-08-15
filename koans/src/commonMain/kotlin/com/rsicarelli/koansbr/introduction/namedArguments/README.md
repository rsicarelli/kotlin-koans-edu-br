## Argumentos nomeados

Em Kotlin, os 'Argumentos nomeados' (`named arguments`) permitem que você especifique o nome do argumento diretamente ao chamar uma função,
tornando o código mais claro e fácil de entender.

### Tarefa

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

### Caso de uso

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

#### Vantagens

- **Legibilidade de código**: ao chamar uma função com vários argumentos, especialmente se eles são do mesmo tipo, pode ser difícil entender
  a que cada argumento se refere. Adicionar nomes aos seus argumentos os tornam explícitos, elevando a coesão do seu código e evitando
  problemas futuros.
- **Elimina a necessidade de [sobrecarga de funções](https://pt.wikipedia.org/wiki/Sobrecarga_de_fun%C3%A7%C3%A3o)**: no Java, você
  precisaria criar várias versões de uma função para lidar com diferentes
  números de argumentos. Em Kotlin, você pode usar argumentos nomeados combinados com argumentos padrão para evitar essa sobrecarga.
- **Permite a reordenação de argumentos:** Com argumentos nomeados, você não precisa se lembrar da ordem dos argumentos ao chamar uma
  função; você pode especificar os argumentos na ordem que quiser.

#### Desvantagens

- **Compatibilidade entre versões:** Se o nome de um argumento é alterado na função, qualquer código que chame essa função usando um
  argumento nomeado precisará ser atualizado. Isso pode tornar as mudanças no código mais problemáticas do que se estivesse usando
  argumentos posicionais (quando você passa valores baseados apenas na ordem, sem especificar nomes).
- **Verbosidade:** Em alguns casos, o uso de argumentos nomeados pode tornar o código mais verboso, especialmente se o nome do argumento for
  longo.

### Dicas

- Você pode criar uma instância de `List` utilizando a
  função [`listOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html)
- Posicione o cursor sobre uma função, aperte `Alt + Enter` e selecione `Adicionar nomes aos argumentos`
- Pode usar o `Alt + Enter` também para `Colocar os argumentos em linhas separadas`

### Analogia

#### Named arguments e o restaurante à la carte

Imagine que você está em um restaurante à la carte onde cada prato tem diversas opções de acompanhamentos. Quando você faz o pedido, em
muitos lugares, é necessário escolher os acompanhamentos em uma sequência específica: primeiro a salada, depois o purê, a seguir o arroz, e
assim por diante. Isso seria equivalente a chamar uma função sem usar argumentos nomeados; você precisa conhecer e seguir uma ordem
específica.

Porém, neste restaurante especial, eles têm um sistema diferente. Ao fazer o pedido, você simplesmente diz: "Quero o Tofu com salada de:
Lentilha, arroz: integral, e purê: de batata-doce." Não importa a ordem em que você menciona os acompanhamentos; o garçom anota exatamente o
que você quer, da maneira que você especificou.

Os `Named Arguments` em Kotlin funcionam de maneira semelhante. Em vez de fornecer argumentos em uma ordem específica, você pode
simplesmente nomeá-los, tornando o código mais claro e menos propenso a erros. Em vez de se lembrar da sequência correta, você só precisa
saber o nome do argumento que deseja fornecer.
