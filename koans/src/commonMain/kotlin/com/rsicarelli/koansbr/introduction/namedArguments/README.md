# Argumentos nomeados (Named arguments)

<details>
<summary>&nbsp;<b>Tabela de conteúdo</b></summary>

<p></p>

<!-- TOC -->
* [Argumentos nomeados (Named arguments)](#argumentos-nomeados-named-arguments)
  * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [Clareza nos Argumentos](#clareza-nos-argumentos)
    * [Ordens Flexíveis](#ordens-flexíveis)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
  * [Exercícios](#exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.kt)

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

[Argumentos nomeados](https://kotlinlang.org/docs/kotlin-tour-functions.html#named-arguments) são como etiquetas que você coloca nos valores
que você passa para uma função. Isso torna o código mais claro e evita confusões.

Vamos considerar uma função `enviarEmail` que aceita informações do remetente e destinatário:

```kotlin
fun enviarEmail(
    de: String,
    para: String,
    assunto: String,
) = Unit
```

Sem argumentos nomeados, você usaria assim:

```kotlin
enviarEmail(
    "remetente@examplo.com",
    "destinatario@examplo.com",
    "Sobre a Reunião"
)
```

Mas com argumentos nomeados, você pode especificar diretamente cada valor:

```kotlin
enviarEmail(
    de = "remetente@examplo.com",
    para = "destinataria@examplo.com",
    assunto = "Sobre a Reunião"
)
```

### Clareza nos Argumentos

Se você só quiser definir o assunto, deixando os outros valores como padrão:

```kotlin
enviarEmail(assunto = "Cancelamento da Reunião")
```

### Ordens Flexíveis

Imagine que você queira mudar a ordem dos valores, mas ainda mantendo tudo claro:

```kotlin
enviarEmail(
    assunto = "Lembrete",
    para = "area@example.com",
    de = "equipe@example.com"
)
```

### Vantagens

- **Clareza nos Valores**: os nomes atribuídos esclarecem o propósito de cada argumento.
- **Ordem Flexível**: você pode mudar a ordem dos valores sem confusão.
- **Configuração Simplificada**: ótimo para funções com muitos parâmetros, onde você pode pular valores padrão.
- **Personalização Precisa**: ideal para personalizar funções complexas sem se perder.

### Desvantagens

- **Atualizações de Nomes**: renomear um argumento na função exige atualizações em todos os locais onde a função é chamada.
- **Aumento da Verbosidade**: nomes longos podem tornar o código mais extenso.

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
