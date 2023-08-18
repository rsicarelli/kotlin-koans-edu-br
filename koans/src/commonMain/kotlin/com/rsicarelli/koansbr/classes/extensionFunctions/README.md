## Extension functions

Em Kotlin, As [Extension Functions](https://kotlinlang.org/docs/extensions.html#extension-functions) são uma ferramenta poderosa que permite
adicionar novas funcionalidades a uma classe sem a necessidade de
modificá-la ou herdar-la: você a "estende".

### Tarefa

https://play.kotlinlang.org/koans/Classes/Extension%20functions/Task.kt

Implemente as funções de extensão `Int.r()` e `Pair.r()` e faça com que elas convertam `Int` e `Pair` em um `RationalNumber`.

#### Pair

Em Kotlin, [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/) é uma classe que representa um valor composto por dois
elementos - uma 'dupla'. É uma maneira simples de armazenar dois
valores relacionados juntos, mas sem semântica particular.

`Pair` é uma classe definida na `stdlib`:

```kotlin
data class Pair<out A, out B>(
    val first: A,
    val second: B
)
```

### Casos de uso

Ao criar uma extensão, essa função atua como se fosse um membro daquela classe, mas internamente o compilador a trata como apenas uma função
comum que aceita uma instância daquela classe como seu primeiro parâmetro.

```kotlin
fun String.printHello() {
    println("Hello, $this")
}

val name = "Kotlin"
name.printHello() // Imprime: "Hello, Kotlin"
```

No exemplo acima, a função `printHello` é extension function para a classe `String`. No contexto dessa função, `$this` refere-se ao objeto
`String` ao qual a função foi aplicada.

#### Como Elas Funcionam?

Por baixo dos panos, uma extensão é apenas uma função estática que recebe o objeto que você está "expandindo" (o objeto receptor)
como seu primeiro argumento.

Dessa forma, não existe uma sobrecarga de desempenho ao usar funções de extensão em comparação com funções normais.

### Vantagens

- **Melhora a legibilidade do código**: Muitas vezes, chamar um método em um objeto é mais intuitivo do que passar o objeto como um
  argumento para uma função.
- **Evita poluição do namespace**: Ao invés de criar funções de utilidade genérica, você pode criar as suas próprias extensões privadas
  apenas no contexto onde ela é utilizada.
- **Evita subclasses desnecessárias**: Em vez de criar uma subclasse apenas para adicionar algumas funcionalidades, você pode criar
  extensões

### Desvantagens

- **Não substituem métodos originais**: Se a classe original tiver um método com a mesma assinatura da função de extensão, o método original
  será chamado.
- **Acesso limitado**: funções de extensão não podem acessar membros protegidos ou privados da classe.
- **Podem levar à confusão**: O uso excessivo sem organização adequada pode tornar o código difícil de entender.

#### Testabilidade

- **Isolamento e Pureza**: Idealmente, as funções de extensão devem operar como funções puras, tornando os testes mais previsíveis.
- **Restrição de Acesso**: Sua incapacidade de acessar membros privados torna as funções de extensão mais fáceis de testar.
- **Simplicidade**: funções de extensão devem ter uma única responsabilidade. Isto facilita o teste.






