### Índice:

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. ➡️ **[Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)**
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)

---

### Tarefa

[Kotlin Koans: Named arguments](https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.kt)

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

---

## Argumentos nomeados (Named arguments)

Em Kotlin, os [Argumentos nomeados](https://kotlinlang.org/docs/kotlin-tour-functions.html#named-arguments) permitem que você especifique o
nome do argumento diretamente ao chamar uma função, tornando o código mais claro e fácil de entender.

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

### Vantagens

- **Legibilidade**: Argumentos nomeados esclarecem a que cada valor se refere, melhorando a compreensão.
- **Evita sobrecarga**: Ao invés de várias funções para diferentes números de argumentos, use argumentos nomeados e padrão.
- **Flexibilidade na ordem**: Não precisa lembrar da ordem dos argumentos; ordene como preferir.

### Desvantagens

- **Risco em mudanças**: Alterações no nome de um argumento requerem atualizações no código que o usa.
- **Pode aumentar verbosidade**: Em certos casos, usar nomes longos pode tornar o código mais extenso.

---
## Analogia

### Named arguments e o restaurante à la carte

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
