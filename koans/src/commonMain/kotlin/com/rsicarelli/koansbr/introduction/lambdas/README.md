### Índice:

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. 📖 **[Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)**

---
## Tarefa

[Kotlin Koans: Lambdas](https://play.kotlinlang.org/koans/Introduction/Lambdas/Task.kt)

Passe um lambda para a função [`any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html)
para verificar se a coleção contém um número par.
A função `any` recebe um predicado como argumento e retorna verdadeiro se pelo menos um elemento satisfizer o predicado.
---
# Lambdas

[Lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) são uma das características mais poderosas e
elegantes introduzidas em linguagens de programação modernas, e Kotlin não é exceção. Imagine conseguir representar uma ação ou
comportamento como um objeto, de forma concisa e clara, e poder passar essa ação como se fosse uma variável comum. Isso é, em essência, o
que os lambdas permitem fazer.

Em Kotlin, lambdas são funções anônimas: elas são funções que não têm nome. Isso pode parecer estranho à primeira vista, mas a beleza está
em sua simplicidade. Em vez de definir uma função completa para realizar uma pequena tarefa, você pode simplesmente definir um bloco de
código e passá-lo onde for necessário. Isso é especialmente útil em operações de curta duração e baixo processamento, como processar itens
em uma lista ou responder a um clique em um botão.

Além de sua concisão, os lambdas são tratadas como qualquer outro tipo em Kotlin. Isso significa que você pode armazená-las em variáveis,
passá-las como parâmetros e até mesmo retorná-las de outras funções. Esse recurso abre uma ampla gama de possibilidades, especialmente
quando se trata de programação funcional e design de API expressivo.

Em Kotlin, toda expressão lambda é envolvida por chaves `{}`. Dentro delas, os parâmetros ficam à esquerda do símbolo `->`, enquanto o
conjunto de instruções da função, ou seu corpo, fica à direita.

## Caso de uso

```kotlin
val multiplyByTwo: (Int) -> Int = { number -> number * 2 }
val result = multiplyByTwo(4) //8
```

No exemplo acima, recebemos `Int` como argumento e retornamos `Int` como resultado. No corpo da função, nomeamos o argumento como `number` e
o multiplicamos por 2.

Quando a expressão lambda é o último argumento de uma função, a sintaxe pode ser simplificada movendo-a para fora dos parênteses.

```kotlin
list.any({ number -> number % 2 == 0 })
// podemos simplificar removendo os parenteses
list.any { number -> number % 2 == 0 }
```

#### Vantagens

- **Sintaxe concisa**: Lambdas oferecem uma sintaxe mais curta e clara para funções, resultando em um código mais limpo.
- **[Funções de ordem superior](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
  e [programação funcional](https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_funcional)**: lambdas trazem capacidade para usar funções de
  ordem superior, criando um novo nível de abstração e possibilitando código mais expressivo.
- **Passagem de comportamento**: Com lambdas, o comportamento de uma função pode ser passado como argumento, tornando o código mais flexível
  e reutilizável.
- **Integração com APIs modernas**: Lambdas integram-se perfeitamente com APIs 'kotlin-first', como
  o [Jetpack Compose](https://developer.android.com/jetpack/compose) e outras, tornando o código mais idiomático em Kotlin.

#### Desvantagens

- **Desempenho**: Lambdas podem ter eficiência reduzida em certos casos, como captura intensiva de contexto.
- **Legibilidade**: Códigos com uso intensivo de lambdas podem ser complexos se compreender, especialmente para iniciantes em programação
  funcional.
- **Depuração**: Devido à sua natureza anônima, depurar lambdas pode ser mais complicado, levando a stacktraces complexas.
- **Retrocompabitilidade com Java é limitada**: As versões abaixo de Java 8 não suportam lambdas sem o uso de plug-ins ou ferramentas
  adicionais.

#### O que é `it`?

Em Kotlin, quando você trabalha com lambdas que têm apenas um parâmetro, esse único parâmetro pode ser acessado implicitamente usando a
palavra-chave `it`, sem precisar declará-lo explicitamente.

Imagine que você tem uma lista de números e quer filtrar apenas os pares. Usando lambdas, você poderia fazer algo assim:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { number -> number % 2 == 0 }
```

No exemplo acima, o lambda passado para a função filter tem um único parâmetro, `number`, que representa cada item da lista durante a
iteração.

Porém, como é comum ter lambdas com um único parâmetro, Kotlin oferece uma forma mais concisa de fazer o mesmo, usando o it:

```kotlin
val evenNumbers = numbers.filter { it % 2 == 0 }
```

Aqui, `it` refere-se automaticamente ao único parâmetro do lambda, que, neste caso, é cada item da lista `numbers`.

### Testabilidade

- **Isolação**: Teste cada lambda de forma isolada, assim como faria com qualquer outra unidade de código.
- **Entradas e Saídas**: Verifique o comportamento do lambda baseado nas entradas e saídas. Garanta que produza o resultado desejado para as
  entradas fornecidas.
- **Teste com múltiplos casos**: Assim como qualquer função, um teste de lambda deve abranger múltiplos casos, incluindo "edge cases" ou os
  casos extremos, excepcionais.
- **Simplicidade**: Lambdas idealmente devem ser simples e de responsabilidade única, o que facilita o teste. Se um lambda torna-se complexo
  demais, considere refatorá-lo.

### Analogia

#### Lambdas e o Canivete Suíço

Imagine um canivete suíço, que você pode configurar rapidamente para atender a uma necessidade específica. Se precisa cortar algo, desliza
para fora a lâmina. Se precisa de uma tesoura, puxa a pequena tesoura embutida. Cada configuração do canivete é uma resposta rápida e
específica para uma necessidade pontual.

Em programação, muitas vezes temos tarefas pequenas e específicas que queremos resolver sem criar uma ferramenta completa (ou seja, uma
função ou classe completa com nome e tudo mais).

Lambdas, então, são como esse canivete suíço:

- Precisa fazer algo rapidamente com um item em uma lista? Configure seu "canivete" (lambda) para isso.
- Precisa transformar um valor? Ajuste seu canivete para essa transformação.

Assim como você não daria um nome específico para cada configuração que faz com seu canivete suíço, você não precisa nomear seus lambdas.

E assim como o canivete é portátil e pode ser usado em diferentes situações, os lambdas podem ser passadas por aí em seu código, tornando
tudo mais flexível e conciso.

#### Lambdas e RPG

Imagine um RPG (Role-Playing Game) onde seu personagem tem uma habilidade chamada "Magia Diferenciada". Esta habilidade permite que você,
em vez de escolher entre magias pré-definidas, crie rapidamente um feitiço para lidar com situações específicas.

Por exemplo, você está enfrentando um monstro que é resistente a fogo. Em vez de procurar em sua lista de feitiços e habilidades, você usa
a "Magia Diferenciada" e rapidamente cria um feitiço de gelo, definindo os parâmetros: "Alvo: Monstro; Elemento: Gelo; Intensidade: Média".

Nesta analogia:

- **"Magia Diferenciada"**: representa o conceito de lambdas. Em vez de ter que criar e nomear uma função específica para cada situação,
  você tem a flexibilidade de definir rapidamente o que deseja que essa "habilidade" faça, dependendo da situação.

- **Definir os parâmetros da magia**: É como definir a expressão lambda. Em um contexto específico, você diz exatamente o que deseja que ela
  faça.

Desta forma, lambdas são como essa "Magia Personalizada" no mundo da programação. Permitem que você crie soluções rápidas e específicas para
problemas sem ter que definir e nomear funções completas para cada situação. É a ferramenta perfeita para um herói (ou programador) que
precisa de flexibilidade e eficiência em suas aventuras!
