# Modelos de string (String templates)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Modelos de string (String templates)](#modelos-de-string-string-templates)
    * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [O que são as String templates em Kotlin?](#o-que-são-as-string-templates-em-kotlin)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
    * [String templates e um quebra cabeça](#string-templates-e-um-quebra-cabeça)
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

Um template é como um espaço reservado onde você coloca um cifrão `$` seguido do nome da variável. O valor real
será colocado no espaço do template quando a string for usada.

```kotlin
val nome = "Mel"
println("Bom dia, $nome.") // Saída: Bom dia, Mel.
```

Você também pode usar expressões mais complicadas dentro deles, envolvendo a expressão com
chaves `${}`. Isso é como resolver um problema de matemática em uma frase.

```kotlin
val nome = "Alex"
val idade = 35
println("Olá, $nome. Você irá completar ${idade + 5} em cinco anos.") // Olá, Alex. Você irá completar 40 em cinco anos.
```

### O que são as String templates em Kotlin?

Em Kotlin, as [string templates](https://kotlinlang.org/docs/strings.html#string-templates) são uma maneira interessante de criar strings
que incluem valores de variáveis ou expressões. Isso é como colocar peças de um quebra-cabeça numa frase para fazer sentido.

As cadeias de caracteres entre aspas triplas não são úteis apenas para cadeias de caracteres de várias linhas, mas também
para criar padrões de regex, pois não é necessário escapar de uma barra invertida com uma barra invertida.

### Vantagens

- **Fácil e Limpo**: Templates de string ajudam você a criar mensagens combinando texto com variáveis de uma forma simples e limpa.
- **Fácil Leitura**: As mensagens criadas com templates são fáceis de entender, pois fica claro onde estão os valores das variáveis.
- **Evita Erros**: Usar templates evita erros que podem acontecer quando você precisa juntar várias partes de texto e variáveis.

### Desvantagens

- **Complexidade**: Se você exagerar nos templates, a string pode ficar difícil de entender.
- **Riscos de segurança**: Se você inserir informações do usuário diretamente nos templates, pode abrir brechas para problemas de segurança.
- **Problemas de desempenho**: Em situações específicas, usar muitos templates pode ser menos eficiente que juntar strings, especialmente
  para textos muito grandes.

## Analogia

### String templates e um quebra cabeça

Imagine que você está montando um quebra-cabeça. Cada peça do quebra-cabeça é única e se encaixa perfeitamente em um espaço específico. Cada
peça se assemelha a um "template" - um espaço vazio que aguarda a peça certa. Você não pode simplesmente
encaixar qualquer peça em qualquer lugar.

Da mesma forma, ao usar string templates, você está criando um espaço vazio em sua mensagem, onde
um valor específico deve ser inserido.

Montar um quebra-cabeça é como criar uma mensagem em etapas, encaixando peças para formar uma imagem. Usar string templates é semelhante -
você está montando uma mensagem, encaixando valores em espaços vazios. Em ambos os casos, você obtém um resultado coeso e cheio de
significado!

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
