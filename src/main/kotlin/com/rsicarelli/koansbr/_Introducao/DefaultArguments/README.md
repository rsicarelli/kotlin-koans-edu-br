## Argumentos Predefinidos

Em Kotlin, pode-se definir um valor padrão para um argumento de uma função. Isto é referido como argumentos predefinidos,
ou [`default arguments`](https://kotlinlang.org/docs/functions.html#default-arguments).

Esta é uma característica útil que permite que
argumentos sejam omitidos quando uma função é chamada, nesse caso, o
compilador usará os valores predefinidos para esses argumentos.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Default%20arguments/Task.kt

Imagine que você tenha várias sobrecargas de `foo()` em Java:

```java
class SobrecargaJava {
    public String foo(String name, int number, boolean toUpperCase) {
        return (toUpperCase ? name.toUpperCase() : name) + number;
    }

    public String foo(String name, int number) {
        return foo(name, number, false);
    }

    public String foo(String name, boolean toUpperCase) {
        return foo(name, 42, toUpperCase);
    }

    public String foo(String name) {
        return foo(name, 42);
    }
}
```

Você pode substituir todas essas sobrecargas do Java por uma única função em Kotlin.

Altere a declaração da função `foo` de forma que o código que usa `foo` seja compilado.

## Caso de uso

```kotlin
fun display(name: String, age: Int = 50) {
    println("Nome: $name, Idade: $age")
}

fun main(args: Array<String>) {
    display("Aurora") // A idade não é passada
    display("João", 30) // A idade é passada
}
```

No exemplo acima, a função `display` recebe dois argumentos, `name` e `age`.

Perceba que no argumento `age`, temos uma idade predefinida como `50`. Assim, quando chamamos a função `display` e omitimos o
argumento `age`, a função irá mostrar `50` para a idade.

No entanto, se passarmos o argumento `age`, como fizemos na segunda chamada da função, o valor passado `30` será usado, e não o valor
predefinido.

### Vantagens

- **Menos sobrecarga de funções**: Em vez de criar várias versões da mesma função com diferentes listas de parâmetros, podemos fornecer
  valores padrão para alguns parâmetros.
- **Flexibilidade ao chamar as funções**: Podemos chamar a mesma função com diferentes números de argumentos, enquanto todos os argumentos
  sem um valor padrão sejam fornecidos.
- **Código mais limpo e menos verboso**: O uso de argumentos padrão ajuda a reduzir a quantidade de código que precisa ser escrita para
  atender a todos os casos de uso possíveis de uma função.
- **Compatibilidade total com Java**: Funções com argumentos padrão podem ser chamadas a partir do código Java, como se fossem sobrecargas
  da mesma função.

### Desvantagens

- **Complexidade do código:** O uso excessivo de argumentos padrão pode tornar o código mais difícil de ler e entender, especialmente para
  programadores menos experientes.
- **Parâmetros padrão discartados no bytecode Java:** Quando utilizamos funções do Java no Kotlin, os valores padrão não estão disponíveis e
  cada combinação precisa ser sobrecarregada explicitamente na função `@JvmOverloads` para que os valores padrão sejam usados.

## Notas

- O uso de argumentos padrão é uma ferramenta poderosa e pode ajudar a escrever um código mais limpo e eficiente, mas, como
  sempre, é importante usá-los com moderação e atenção para evitar a complexidade desnecessária

## Dicas

- Na tarefa, o número `42` é um ótimo candidato para ser um argumento predefinido.
