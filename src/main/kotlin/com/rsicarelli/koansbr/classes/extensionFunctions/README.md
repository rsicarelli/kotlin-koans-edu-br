## Extension functions

As [Extension Functions](https://kotlinlang.org/docs/extensions.html#extension-functions) em Kotlin são recursos que permitem "estender" uma
classe com novas funcionalidades sem precisar herdar dela ou usar qualquer tipo de padrão de ‘design’. Basicamente, você anexa uma nova
função a uma classe existente.

### Tarefa

https://play.kotlinlang.org/koans/Classes/Extension%20functions/Task.kt

Implemente as funções de extensão `Int.r()` e `Pair.r()` e faça com que elas convertam `Int` e `Pair` em um `RationalNumber`.

#### Pair

Em Kotlin, [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/) é uma classe que representa um valor composto por dois elementos - uma 'dupla'. É uma maneira simples de armazenar dois
valores relacionados juntos, mas sem semântica particular.

`Pair` é uma classe definida na `stdlib`:

```kotlin
data class Pair<out A, out B>(
    val first: A,
    val second: B
)
```

### Casos de uso

```kotlin
fun String.printHello() {
    println("Hello, $this")
}

val name = "Kotlin"
name.printHello() // Imprime: "Hello, Kotlin"
```

No Kotlin, uma "função de extensão" funciona essencialmente da mesma maneira que uma função comum. A diferença principal é que a função de
extensão tem um "objeto recepitor" (a instância que chama a função de extensão) que, nos bastidores, é passado como o primeiro parâmetro da
função.

Em outras palavras, quando você cria uma função de extensão no Kotlin, o compilador transforma essa função de extensão em uma função
estática normal, onde o objeto que você está "estendendo" (o objeto recepitor) é passado como o primeiro argumento dessa função. Isso
significa não haver impacto adicional no desempenho ao usar funções de extensão, quando comparado com as funções comuns.

#### Vantagens

- **Melhora a legibilidade do código**: Às vezes, é mais natural chamar um método em um objeto do que passar o objeto para uma função. As
  funções de extensão permitem que você faça isso mesmo se não controlar a classe original.
- **Evita poluição de namespace**: Você pode definir funções de extensão em classes onde faz sentido usá-las, em vez de criar funções de
  utilidade genérica.
- **Evita subclasses desnecessárias**: As funções de extensão podem ser uma alternativa melhor do que criar subclasses apenas para adicionar
  funcionalidades extras a uma classe.

#### Desvantagens

- **Não substituem os métodos originais**: Se a classe original tem um método com a mesma assinatura que a função de extensão, o método
  original terá prioridade.
- **Não podem acessar membros protegidos ou privados da classe**: Funções de extensão apenas têm acesso aos mesmos membros públicos do
  objeto que qualquer outra classe.
- **Podem causar confusão**: Muitas extensões em um código podem dificultar o rastreamento de quais funções são realmente parte de uma
  classe e quais são extensões. Manter a moderação e a organização é fundamental.

#### Testabilidade

1. **Isolamento e Pureza:**
   As extensions functions são naturalmente isoladas devido ao seu baixo acoplamento. Para melhor testabilidade, elas idealmente devem
   operar como funções puras, retornando o mesmo resultado para um conjunto de entradas específico e sem efeitos colaterais. Assim, os
   testes podem focar apenas nas entradas e saídas.

2. **Restrição de Acesso:**
   As funções de extensão não têm acesso a membros privados da classe alvo. Isso restringe a superfície de interação, tornando mais simples
   e direto testar a função, já que ela só pode interagir com os métodos públicos da classe.

3. **Simplicidade:**
   Funções de extensão devem ser mantidas simples e com uma única responsabilidade. Quanto mais direta for a função, mais fácil será
   testá-la, independentemente da abordagem ou ferramenta de teste escolhida.






