## Funções

```kotlin
fun nomeDaFuncao(param1: Tipo, param2: Tipo): TipoDeRetorno {
    // corpo da função
}
```

`fun`: Palavra-chave, ou palavra reservada que indica que você está declarando uma função ou um método.

`nomeDaFuncao`: O nome da função que você está declarando. Em Kotlin, a convenção de nomenclatura normalmente usa camelCase.

`(param1: Tipo, param2: Tipo)`: a lista de argumentos da função, separados por vírgula. Obrigatoriamente cada argumento precisa ter um nome
e um tipo.

`: TipoDeRetorno`: O tipo de valor que a função irá retornar, podendo ser
qualquer [tipo válido em Kotlin](https://kotlinlang.org/docs/basic-types.html), incluindo tipos personalizados on internos do seu domínio.

`{}`: Este é o corpo da função, onde o código será executado quando a função for chamada.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt

Altere o código para que a função `start` retorne a string `"OK"`.

Nas tarefas do Kotlin Koans, a função `TODO()` lançará uma exceção.
Para concluir o Kotlin Koans, você precisa substituir essa invocação de função por um código significativo de acordo com o problema.

## Nota

- Se a função não retorna um valor, você pode omitir o retorno. Por padrão, todas as funções que não retornam nada tem um
  tipo [`Unit`](https://kotlinlang.org/docs/functions.html#unit-returning-functions) - a função retornará implicitamente "uma unidade".

```kotlin
fun semRetorno(): Unit = Unit
fun semRetorno(): Unit = { }
fun semRetorno() = Unit
fun semRetorno() = { }
```
