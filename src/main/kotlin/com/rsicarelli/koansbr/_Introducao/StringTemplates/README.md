## Templates com String

Em Kotlin, [template de strings](https://kotlinlang.org/docs/strings.html#string-templates) (`string templates`) são expressões embutidas de
aspas `""` que são avaliadas para compor outra string. Eles permitem que você insira valores de variáveis ou mesmo expressões completas
dentro de suas strings.

As cadeias de caracteres entre aspas triplas não são úteis apenas para cadeias de caracteres de várias linhas, mas também
para criar padrões de regex, pois não é necessário escapar de uma barra invertida com uma barra invertida.

### Tarefa
O padrão a seguir corresponde a uma data no formato `13.06.1992`
(dois dígitos, um ponto, dois dígitos, um ponto, quatro dígitos):

```kotlin
fun getPattern() = """\d{2}\.\d{2}\.\d{4}"""
```

Usando a variável `month`, reescreva esse padrão de forma que ele corresponda à data no formato `13 JUN 1992`
(dois dígitos, um espaço em branco, uma abreviação de mês, um espaço em branco, quatro dígitos).

### Caso de uso

Para usar um template de string em Kotlin, você adiciona um `$` antes do nome da variável que você deseja incluir no texto. Por exemplo:

```kotlin
val nome = "Mel"
println("Bom dia, $nome.") // Saída: Bom dia, Mel.
```

Também é possível incluir uma expressão mais complexa na sua string, você pode cercá-la com chaves `${}`:

```kotlin
val nome = "Alex"
val idade = 35
println("Olá, $nome. Você irá completar ${idade + 5} em cinco anos.") // Olá, Alex. Você irá completar 40 em cinco anos.
```

#### Vantagens

- **Sintaxe limpa**: os templates de string permitem combinar texto e variáveis (ou expressões) de maneira muito limpa e concisa.
- **Legibilidade e manutenibilidade melhoradas**: os templates de string podem tornar o código mais legível e fácil de manter, pois é fácil
  ver exatamente o que está sendo incorporado à string.
- **Evita erros de concatenação**: usar templates de string pode ajudar a evitar erros que podem ocorrer ao concatenar strings,
  especialmente quando você tem várias variáveis e textos para combinar.

#### Desvantagens

- **Complexidade da string aumentada**: Se você tem uma string muito complexa com muitos templates embutidos, pode tornar a string difícil
  de ler e entender.
- **Riscos de segurança**: Assim como no caso de [SQL Injection](https://pt.wikipedia.org/wiki/Inje%C3%A7%C3%A3o_de_SQL), se você estiver
  incorporando entradas do usuário diretamente em suas strings através de templates de string, você pode estar abrindo uma possibilidade de
  [Cross-Site Scripting (XSS)](https://pt.wikipedia.org/wiki/Cross-site_scripting) ou outros ataques.
- **Problemas de desempenho**: Em algumas situações, os templates de string podem ter um desempenho pior em comparação com a concatenação de
  strings, especialmente se a string resultante for muito grande.
