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

### Outros tipos básicos de função

#### Funções de linha única

Para funções expressas em uma única linha, Kotlin permite uma sintaxe simplificada.

```kotlin
fun somar(a: Int, b: Int): Int = a + b
```

#### Tipo de retorno inferido

Para funções com corpos de expressão, o tipo de retorno pode ser inferido pelo compilador e, pode ser omitido.

```kotlin
fun somar(a: Int, b: Int) = a + b  // O compilador sabe que o tipo de retorno é Int
```

#### Funções com Varargs

Você pode passar um número variável de argumentos para uma função usando o modificador `vararg`.

```kotlin
fun imprimirNomes(vararg nomes: String) {
    for (nome in nomes) {
        println(nome)
    }
} 
```

### Tarefa

https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt

Altere o código para que a função `start` retorne a string `"OK"`.

Nas tarefas do Kotlin Koans, a função `TODO()` lançará uma exceção.
Para concluir o Kotlin Koans, você precisa substituir essa invocação de função por um código significativo de acordo com o problema.

### Nota

- Se a função não retorna um valor, você pode omitir o retorno. Por padrão, todas as funções que não retornam nada tem um
  tipo [`Unit`](https://kotlinlang.org/docs/functions.html#unit-returning-functions) - a função retornará implicitamente "uma unidade".

```kotlin
fun semRetorno(): Unit = Unit
fun semRetorno(): Unit = { }
fun semRetorno() = Unit
fun semRetorno() = { }
```

### Analogia

Imagine que uma função em Kotlin é como uma máquina de café automatizada:

1. **Nome da Função** - É como o nome da bebida que você deseja. Por exemplo, "Cappuccino", "Latte" ou "Espresso".

2. **Parâmetros da Função** - São como os ingredientes ou personalizações que você pode escolher ao fazer seu café. Por exemplo, você pode
   escolher a quantidade de açúcar, se deseja alguma bebida vegetal ou se prefere um café descafeinado.

3. **Tipo de Retorno** - É o tipo de bebida que a máquina entrega. Se você selecionar "Cappuccino", a máquina lhe entregará um cappuccino e
   não um espresso.

4. **Corpo da Função** - É o processo interno da máquina. Você não vê exatamente como a máquina faz o café, mas sabe que ela está fazendo
   seu trabalho internamente e, no final, entrega a bebida escolhida.

5. **Chamar a Função** - É como pressionar o botão na máquina para obter sua bebida. Assim que você seleciona as opções desejadas e
   pressiona o botão (ou seja, chama a função em Kotlin), a máquina (função) faz o trabalho e entrega o café (resultado).

6. **Valor Padrão** (que é um conceito em Kotlin) - Pode ser comparado a escolher um café "regular" sem personalizações específicas. Se você
   não especificar suas preferências, a máquina simplesmente lhe dá a versão padrão da bebida.

Usando esta analogia, pense numa função em Kotlin como numa máquina de café: você seleciona a bebida, define suas personalizações e, em
seguida, a máquina prepara e entrega exatamente o que você pediu.
