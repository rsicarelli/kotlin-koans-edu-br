# Argumentos nomeados (Named arguments)

<details>
<summary> <b>Conteúdo</b> (clique para expandir) </summary>

<!-- TOC -->
* [Argumentos nomeados (Named arguments)](#argumentos-nomeados-named-arguments)
  * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [Definindo apenas o necessário](#definindo-apenas-o-necessário)
    * [Flexibilidade na organização](#flexibilidade-na-organização)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
  * [Exercícios](#exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.kt)

Faça com que a das `joinOptions()` retorne a lista em formato [JSON](https://pt.wikipedia.org/wiki/JSON) (por exemplo, `[a, b, c]`)
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

Ao se deparar com [Argumentos nomeados](https://kotlinlang.org/docs/kotlin-tour-functions.html#named-arguments) em Kotlin, imagina-se
colocando etiquetas em valores enviados para funções, tornando tudo mais compreensível e minimizando equívocos.

```kotlin
fun enviarEmail(
    de: String,
    para: String,
    assunto: String,
) = Unit
```

Normalmente, a função seria usada da seguinte maneira:

```kotlin
enviarEmail(
    "remetente@examplo.com",
    "destinatario@examplo.com",
    "Sobre a Reunião"
)
```

Mas com argumentos nomeados, cada valor é especificado de maneira clara:

```kotlin
enviarEmail(
    de = "remetente@examplo.com",
    para = "destinataria@examplo.com",
    assunto = "Sobre a Reunião"
)
```

### Definindo apenas o necessário

Digamos que só o assunto precisa ser definido, deixando o resto como padrão:

```kotlin
enviarEmail(assunto = "Cancelamento da Reunião")
```

### Flexibilidade na organização

Mudar a ordem dos valores? Sem problemas, tudo continua entendível:

```kotlin
enviarEmail(
    assunto = "Lembrete",
    para = "area@example.com",
    de = "equipe@example.com"
)
```

### Vantagens

- **Clareza ao chamar funções**: os argumentos nomeados eliminam qualquer dúvida sobre a correspondência entre os valores fornecidos e os
  parâmetros da função.
- **Flexibilidade**: não há necessidade de seguir a ordem padrão dos parâmetros, permitindo focar apenas nos argumentos relevantes.
- **Redução e prevenção de erros**: Ao nomear argumentos, diminui-se a chance de passar acidentalmente um valor errado para um parâmetro.
- **Documentação implícita**: O código se torna autoexplicativo, reduzindo a necessidade de comentários adicionais para explicar a
  finalidade de cada valor.

### Desvantagens

- **Manutenção de Nomeação**: quando um nome de argumento é alterado na definição da função, todos os lugares que utilizam esse argumento
  precisam ser atualizados.
- **Verbosidade nas chamadas**: em funções com muitos argumentos, nomear cada um pode tornar a chamada da função extensa e poluída.

## Analogia

Imagine entrar numa biblioteca cheia de livros, todos com a mesma capa, sem títulos. Você sabe que ali está o livro que você quer, mas como
encontrar ele no meio de tantos iguais?

Isso lembra programar sem os `named arguments` em Kotlin. A pessoa sabe o que quer fazer, mas sem identificar bem os argumentos, fica fácil
se
perder. No entanto, com named arguments, tudo fica mais claro, como se cada livro tivesse sua própria capa e título.

---

## Exercícios

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. **➡️ [Argumentos nomeados (Named arguments)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md
   )**
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)
