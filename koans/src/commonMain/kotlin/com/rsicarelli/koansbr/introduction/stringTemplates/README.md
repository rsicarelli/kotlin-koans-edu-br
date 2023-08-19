# Modelos de string (String templates)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Modelos de string (String templates)](#modelos-de-string-string-templates)
    * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
  * [Exercícios](#exercícios)
<!-- TOC -->

</details>

### 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/String%20templates/Task.kt)

O padrão a seguir corresponde a uma data no formato `13.06.1992`
(dois dígitos, um ponto, dois dígitos, um ponto, quatro dígitos):

```kotlin
fun getPattern() = """\d{2}\.\d{2}\.\d{4}"""
```

Usando a variável `month`, reescreva esse padrão de forma que ele corresponda à data no formato `13 JUN 1992`
(dois dígitos, um espaço em branco, uma abreviação de mês, um espaço em branco, quatro dígitos).

## Caso de uso

Em Kotlin, as [string templates](https://kotlinlang.org/docs/strings.html#string-templates) são uma maneira de combinar strings com
variáveis ou expressões.

Um modelo de string é como um espaço reservado que é possível inserir um cifrão `$` seguido do nome da variável ou expressão. O valor real
será colocado no espaço nesse modelo quando a string for utilizada.

```kotlin
val nome = "Mel"
println("Bom dia, $nome.") // Saída: Bom dia, Mel.
```

Também é possível ter expressões e chamar outros métodos, adicionando chaves `${}`

```kotlin
fun recuperaNome() = "Dani"
val idade = 35
println("Olá, ${recuperaNome()}. Você irá completar ${idade + 5} em cinco anos.") // Olá, Dani. Você irá completar 40 em cinco anos.
```

### Vantagens

- **Praticidade**: ajudam a criar mensagens sem precisar de funções ou variáveis alternativas.
- **Melhora a leitura**: modelos de string são fáceis de entender, já que fica claro onde estão os valores das expressões.

### Desvantagens

- **Complexidade**: Se você exagerar nos templates, a string pode ficar difícil de entender.
- **Riscos de segurança**: Se você inserir informações do usuário diretamente nos templates, pode abrir brechas para problemas de segurança.
  principalmente se você loga esse valor.
- **Problemas de desempenho**: Em situações específicas, usar muitos templates pode ser menos eficiente que juntar strings, especialmente
  para textos muito grandes.

## Analogia

Imagine um mosaico, uma arte feita de fragmentos que formam uma imagem completa. Nesse mosaico, alguns espaços são deixados
vazios para serem preenchidos posteriormente, conforme a escolha do artista.

Os modelos de string em Kotlin funcionam de maneira similar: as strings são o mosaico completo, e os espaços reservados (ou templates) são
os espaços vazios que serão preenchidos com variáveis ou expressões.

```kotlin
val lugarEspecial = "Praia"
println("Meu lugar especial é $lugarEspecial.")

fun lugarFavorito() = "Montanhas"
println("O lugar favorito da Carla é ${lugarFavorito()}.")
```
---

## Exercícios

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. ➡️ **[Modelos de string (String templates)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md
   )**
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)
