# Introdução

<details open>
<summary>&nbsp;<b>Índice</b> (clique para esconder)</summary>

<p></p>

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. **➡️ [Argumentos padrão (Default arguments)](
https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md
)**
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. [Tipos anuláveis (Nullable types)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md)
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)

</details>

---

## Argumentos padrão (Default arguments)

<details open>
<summary>&nbsp;<b>Tabela de conteúdo</b></summary>

<p></p>

<!-- TOC -->
* [Introdução](#introdução)
  * [Argumentos padrão (Default arguments)](#argumentos-padrão-default-arguments)
    * [Tarefa](#tarefa)
    * [Caso de uso](#caso-de-uso)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
      * [`@JvmOverloads`](#jvmoverloads)
  * [Analogia](#analogia)
    * [Padaria e default arguments](#padaria-e-default-arguments)
<!-- TOC -->

</details>

### Tarefa

[Kotlin Koans: Default Arguments](https://play.kotlinlang.org/koans/Introduction/Default%20arguments/Task.kt)

Imagine que você tenha várias sobrecargas de `foo()` em na sua linguagem favorita.

Você pode substituir todas essas sobrecargas por uma única função em Kotlin.

Altere a declaração da função `foo` de forma que o código que usa `foo` seja compilado.

<details>
  <summary>Java</summary>

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

</details>

<details>
  <summary>C#</summary>

```csharp
using System;

class SobrecargaCSharp
{
    public string Foo(string name, int number, bool toUpperCase)
    {
        return (toUpperCase ? name.ToUpper() : name) + number;
    }

    public string Foo(string name, int number)
    {
        return Foo(name, number, false);
    }

    public string Foo(string name, bool toUpperCase)
    {
        return Foo(name, 42, toUpperCase);
    }

    public string Foo(string name)
    {
        return Foo(name, 42);
    }
}
```

</details>

<details>
  <summary>Dart</summary>

```dart
class SobrecargaDart {
  String foo(String name, int number, bool toUpperCase) {
    return (toUpperCase ? name.toUpperCase() : name) + number.toString();
  }

  String foo(String name, int number) {
    return foo(name, number, false);
  }

  String foo(String name, bool toUpperCase) {
    return foo(name, 42, toUpperCase);
  }

  String foo(String name) {
    return foo(name, 42);
  }
}
```

</details>

<details>
  <summary>Go</summary>

```go
package main

import (
	"fmt"
	"strings"
)

type SobrecargaGo struct{}

func (s SobrecargaGo) Foo(name string, number int, toUpperCase bool) string {
	if toUpperCase {
		return strings.ToUpper(name) + fmt.Sprintf("%d", number)
	}
	return name + fmt.Sprintf("%d", number)
}

func (s SobrecargaGo) FooWithNumber(name string, number int) string {
	return s.Foo(name, number, false)
}

func (s SobrecargaGo) FooWithUpperCase(name string, toUpperCase bool) string {
	return s.Foo(name, 42, toUpperCase)
}

func (s SobrecargaGo) FooWithName(name string) string {
	return s.Foo(name, 42, false)
}
```

</details>

<details>
  <summary>JavaScript</summary>

```javascript
class SobrecargaJavaScript {
    foo(name, number, toUpperCase) {
        return (toUpperCase ? name.toUpperCase() : name) + number;
    }

    fooWithNameAndNumber(name, number) {
        return this.foo(name, number, false);
    }

    fooWithNameAndUpperCase(name, toUpperCase) {
        return this.foo(name, 42, toUpperCase);
    }

    fooWithName(name) {
        return this.foo(name, 42);
    }
}
```

</details>

<details>
  <summary>PHP</summary>

```phpregexp
<?php
class SobrecargaPHP {
    public function foo($name, $number, $toUpperCase) {
        return ($toUpperCase ? strtoupper($name) : $name) . $number;
    }

    public function fooWithNumber($name, $number) {
        return $this->foo($name, $number, false);
    }

    public function fooWithUpperCase($name, $toUpperCase) {
        return $this->foo($name, 42, $toUpperCase);
    }

    public function fooWithName($name) {
        return $this->foo($name, 42, false);
    }
}
```

</details>

<details>
  <summary>Python</summary>

```python
class SobrecargaPython:
    def foo(self, name, number, to_upper_case):
        return (name.upper() if to_upper_case else name) + str(number)

    def foo_with_number(self, name, number):
        return self.foo(name, number, False)

    def foo_with_upper_case(self, name, to_upper_case):
        return self.foo(name, 42, to_upper_case)

    def foo_with_name(self, name):
        return self.foo(name, 42, False)
```

</details>

<details>
  <summary>Swift</summary>

```swift
class SobrecargaSwift {
    func foo(name: String, number: Int, toUpperCase: Bool) -> String {
        return (toUpperCase ? name.uppercased() : name) + String(number)
    }
    
    func foo(name: String, number: Int) -> String {
        return foo(name: name, number: number, toUpperCase: false)
    }
    
    func foo(name: String, toUpperCase: Bool) -> String {
        return foo(name: name, number: 42, toUpperCase: toUpperCase)
    }
    
    func foo(name: String) -> String {
        return foo(name: name, number: 42)
    }
}
```

</details>

<details>
  <summary>TypeScript</summary>

```typescript
class SobrecargaTypeScript {
    foo(name: string, number: number, toUpperCase: boolean): string {
        return (toUpperCase ? name.toUpperCase() : name) + number.toString();
    }

    fooWithNumber(name: string, number: number): string {
        return this.foo(name, number, false);
    }

    fooWithUpperCase(name: string, toUpperCase: boolean): string {
        return this.foo(name, 42, toUpperCase);
    }

    fooWithName(name: string): string {
        return this.foo(name, 42);
    }
} 
```

</details>

---

Os [`default arguments`](https://kotlinlang.org/docs/functions.html#default-arguments) é uma característica útil que permite que argumentos
sejam omitidos quando uma função é chamada, nesse caso,
o compilador usará os "default arguments" para cada argumento.

### Caso de uso

```kotlin
fun printaDetalhes(nome: String, age: Int = 50) {
    println("Nome: $name, Idade: $age")
}

fun main(args: Array<String>) {
    printaDetalhes("Aurora") // A idade não é passada
    printaDetalhes("João", 30) // A idade é passada
}
```

No exemplo acima, a função `printaDetalhes` recebe dois argumentos, `nome` e `idade`.

Perceba que no argumento `idade`, temos uma idade predefinida como `50`. Assim, quando chamamos a função `printaDetalhes` e omitimos o
argumento `idade`, a função irá mostrar `50` para a idade.

No entanto, se passarmos o argumento `idade`, como fizemos na segunda chamada da função, o valor passado `30` será usado, e não o valor
predefinido.

### Vantagens

- **Menos Sobrecargas**: Permite uma única função em vez de várias versões com diferentes argumentos.
- **Flexibilidade**: Você pode chamar a função com diferentes combinações de argumentos, contanto que os obrigatórios sejam fornecidos.
- **Compatibilidade com Java**: Funções com argumentos padrão são compatíveis com código Java, atuando como sobrecargas.

### Desvantagens

- **Complexidade do Código**: Quando utilizado em excesso, pode complicar a leitura e entendimento do código.
- **Descarte no Bytecode Java**: Em Java, os argumentos padrão do Kotlin não são reconhecidos, por isso devemos utilizar a
  anotação `@JvmOverloads` para utilizá-los.

#### `@JvmOverloads`

[`@JvmOverloads`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/) em Kotlin é uma anotação que instrui o compilador
a criar sobrecargas de uma função para cada combinação fornecida.

```kotlin
@JvmOverloads
fun exibeMensagem(conteudo: String, vezes: Int = 1, prefixo: String = "") {
    for (i in 1..vezes) {
        println("$prefixo$conteudo")
    }
}
```

Neste caso, graças à anotação `@JvmOverloads`, o compilador Kotlin gerará as seguintes sobrecargas que podem ser chamadas a partir do código
Java:

```java
class JavaKt {
    void exibeMensagem(String conteudo) {
    }

    void exibeMensagem(String conteudo, int vezes) {
    }

    void exibeMensagem(String conteudo, int vezes, String prefixo) {
    }
}
```

---
## Analogia

### Padaria e default arguments

Pense em uma padaria famosa pelo "_Café Padrão_". Esse café, por padrão, é um café preto de tamanho médio sem nenhum extra.

A padaria, no entanto, sabe que nem todos gostam de seu café dessa maneira. Alguns preferem adicionar leite vegetal, açúcar, caramelo ou até
mesmo chantilly.

Quando um cliente simplesmente pede: "_Um cafézinho, por favor_", o atendente serve o "Café Padrão". Mas, se algum cliente for mais
específico e disser, "_Quero um café grande com caramelo e chantilly_", o atendente personalizá o pedido.

Isso é semelhante ao comportamento dos `default arguments` em Kotlin. Ao criar uma função, você pode determinar valores padrão para alguns
de seus parâmetros. Se a função é chamada sem especificar esses parâmetros, os valores padrão são usados.

Veja este exemplo:

```kotlin
fun pedirCafe(tamanho: String = "médio", adicional: String? = null) {
    // código para preparar o café
}

pedirCafe()  // Retorna: café médio
```

No exemplo acima, ao chamar `pedirCafe()` sem argumentos, você obtém um café médio, que é o comportamento padrão. Porém, pode personalizar
seu pedido:

```kotlin
pedirCafe(
    tamanho = "grande",
    adicional = "com nitrogênio"
)
```

Dessa vez, você terá um café grande com os adicionais especificados.

**É assim que os default arguments funcionam:** eles fornecem um valor padrão, a menos que você especifique algo diferente!




