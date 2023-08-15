## Lambdas

[Lambdas](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions) são funções concisas, podendo ser parâmetros ou resultados de outras funções, tratadas como um tipo.

Em Kotlin, uma expressão lambda é sempre circundada por chaves `{}`. Dentro dessas chaves, você tem multiplos parâmetros à esquerda do
símbolo `->` e o corpo da função à direita.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Lambdas/Task.kt

Passe um lambda para a função [`any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/any.html)
para verificar se a coleção contém um número par.
A função `any` recebe um predicado como argumento e retorna verdadeiro se pelo menos um elemento satisfizer o predicado.

## Caso de uso

```kotlin
val multiplyByTwo: (Int) -> Int = { number -> number * 2 }
val result = multiplyByTwo(4) //8
```
No exemplo acima, recebemos `Int` como argumento e retornamos `Int` como resultado. No corpo da função, nomeamos o argumento como `number` e o multiplicamos por 2.

Quando a expressão lambda é o último argumento de uma função, a sintaxe pode ser simplificada movendo-a para fora dos parênteses.

```kotlin
//`it` é um nome reservado para um argumento único não especificado
list.any({ it % 2 == 0 })

// podemos simplificar removendo os parenteses
list.any { it % 2 == 0 }
```

#### Vantagens
- **Sintaxe concisa**: Lambdas oferecem uma sintaxe mais curta e clara para funções, resultando em um código mais limpo.
- **[Funções de ordem superior](https://kotlinlang.org/docs/lambdas.html#higher-order-functions) e [programação funcional](https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_funcional)**: lambdas trazem capacidade para usar funções de ordem superior, criando um novo nível de abstração e possibilitando código mais expressivo.
- **Passagem de comportamento**: Com lambdas, o comportamento de uma função pode ser passado como argumento, tornando o código mais flexível e reutilizável.
- **Integração com APIs modernas**: Lambdas integram-se perfeitamente com APIs 'kotlin-first', como o [Jetpack Compose](https://developer.android.com/jetpack/compose) e outras, tornando o código mais idiomático em Kotlin.

#### Desvantagens
- **Desempenho**: Lambdas podem ter eficiência reduzida em certos casos, como captura intensiva de contexto.
- **Legibilidade**: Códigos com uso intensivo de lambdas podem ser complexos se compreender, especialmente para iniciantes em programação funcional. 
- **Depuração**: Devido à sua natureza anônima, depurar lambdas pode ser mais complicado, levando a stacktraces complexas. 
- **Retrocompabitilidade com Java é limitada**: As versões abaixo de Java 8 não suportam lambdas sem o uso de plug-ins ou ferramentas adicionais.

### Testabilidade
- **Isolação**: Teste cada lambda de forma isolada, assim como faria com qualquer outra unidade de código.
- **Entradas e Saídas**: Verifique o comportamento do lambda baseado nas entradas e saídas. Garanta que produza o resultado desejado para as entradas fornecidas.
- **Teste com múltiplos casos**: Assim como qualquer função, um teste de lambda deve abranger múltiplos casos, incluindo "edge cases" ou os casos extremos, excepcionais.
- **Simplicidade**: Lambdas idealmente devem ser simples e de responsabilidade única, o que facilita o teste. Se um lambda torna-se complexo demais, considere refatorá-lo.
- **Teste de Integração**: Verifique como o lambda se comporta quando usado em conjunto com outras partes do seu sistema através de testes de integração.
