## Nothing type

O tipo [Nothing](https://kotlinlang.org/docs/exceptions.html#the-nothing-type) pode ser usado como um tipo de retorno para uma função que
sempre lança uma exceção.
Quando você chama uma função desse tipo, o compilador usa a informação de que a execução não continua além da função.

### Tarefa

https://play.kotlinlang.org/koans/Introduction/Nothing%20type/Task.kt

Especifique o tipo de retorno `Nothing` para a função `failWithWrongAge`.

Observe que, sem o tipo `Nothing`, a função `checkAge` não é compilada porque o compilador assume que `age` pode ser `null`.

### Caso de uso

Em Kotlin, `Nothing` é um tipo que representa um valor que nunca ocorre. Em outras palavras, é um tipo que é usado quando uma função nunca
retorna um valor útil.

Por exemplo, uma função que sempre lança uma exceção pode ter `Nothing` como o seu tipo de retorno:

```kotlin
fun alwaysThrowsException(): Nothing {
    throw RuntimeException("Esta função sempre lança uma exceção")
}
```

#### Vantagens

- **Melhora a semântica do código**: Quando você vê `Nothing` como um tipo de função, você sabe imediatamente que essa função nunca retorna
  normalmente (ou seja, ela sempre lança uma exceção ou entra em loop infinito).
- **Ajudando o compilador a inferir tipos com mais precisão**: usar o tipo `Nothing` permite ao compilador inferir tipos em algumas
  situações complexas e garante uma melhor verificação de tipo durante a compilação.

#### Desvantagens

- **Pode ser confuso para novatos**: Para alguém novo em Kotlin, `Nothing` pode não ser imediatamente óbvio. Pode-se pressupor, por engano,
  que é similar ao `void` em outras linguagens, enquanto na verdade é muito diferente.
- **O uso impróprio pode complicar o código**: `Nothing` deve ser usado quando uma função nunca retorna um resultado útil. Usá-lo
  incorretamente pode levar a problemas e tornar o código mais difuso
