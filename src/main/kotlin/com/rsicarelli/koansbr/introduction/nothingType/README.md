## Nothing type

Imagine que você está escrevendo um programa e em certos momentos você quer que uma função sempre lance uma exceção, ou talvez ela entre em
um loop infinito. Nestes casos, o tipo [Nothing](https://kotlinlang.org/docs/exceptions.html#the-nothing-type) pode ser usado como o tipo de
retorno dessa função especial.

Quando você chama uma função que retorna `Nothing`, o compilador entende que algo excepcional está acontecendo. Ele sabe que a execução do
programa não vai continuar normalmente após essa função, então ele lida com isso de maneira especial:

- **Não espera retorno**: Quando chamamos uma função `Nothing`, o compilador não espera um resultado dela, pois sabe que o programa não
  segue
  em frente após isso.

- **Não adivinha tipos**: Se usarmos uma função `Nothing` onde um valor seria esperado, o compilador não tenta adivinhar um tipo. Ele
  entende
  que a função pode encerrar antes de produzir um valor.

- **Aplica otimizações**: O compilador, ciente de que a função é `Nothing`, pode otimizar o código, removendo partes inalcançáveis.

### Tarefa

https://play.kotlinlang.org/koans/Introduction/Nothing%20type/Task.kt

Especifique o tipo de retorno `Nothing` para a função `com.rsicarelli.koansbr.introduction.nothingType.failWithWrongAge`.

Observe que, sem o tipo `Nothing`, a função `com.rsicarelli.koansbr.introduction.nothingType.checkAge` não é compilada porque o compilador assume que `age` pode ser `null`.

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

- **Compreensão mais clara do código**: quando você vê o tipo `Nothing` em uma função, você imediatamente entende que essa função não vai
  retornar normalmente, ou seja, ela vai lançar uma exceção ou ficar em um loop infinito.

- **Ajuda o compilador a entender melhor os tipos**: usar o tipo `Nothing` ajuda o compilador a entender certas situações complexas e
  realizar
  verificações de tipo mais precisas durante a compilação.

#### Desvantagens

- **Pode ser confuso no início**: Se você está começando com Kotlin, o conceito de `Nothing` pode parecer estranho à primeira vista. Algumas
  pessoas podem pensar que é similar ao `void` de outras linguagens, mas na realidade é diferente.

- **Use com cuidado**: Lembre-se de usar o tipo `Nothing` somente quando a função nunca retorna algo útil. O uso incorreto pode tornar o
  código confuso e problemático.

### Analogia

#### O tipo Nothing e uma estrada sem saída

Imagine que você está dirigindo por uma estrada e de repente encontra uma placa que diz "Fim do Caminho". Essa placa indica que não importa o
que aconteça a partir desse ponto, você não pode continuar seguindo a estrada normalmente. Pode haver um abismo, uma ponte quebrada ou algo
incomum.

- A estrada representa o fluxo normal do seu programa.
- A placa "Fim do Caminho" é como uma função que retorna `Nothing`.
- Quando você encontra essa placa, sabe que algo inesperado aconteceu e o programa não vai seguir a rota usual.
- Você não pode continuar dirigindo normalmente, assim como o compilador não espera um valor de retorno normal de uma função `Nothing`.
- A placa é uma indicação de que você está em uma situação incomum, assim como o compilador lida de forma especial com funções que
  retornam `Nothing`.

Em resumo, assim como a placa "Fim do Caminho" muda o curso da sua viagem, uma função que retorna `Nothing` indica ao compilador que algo
anormal está ocorrendo, e ele ajusta a maneira como lida com essa situação.