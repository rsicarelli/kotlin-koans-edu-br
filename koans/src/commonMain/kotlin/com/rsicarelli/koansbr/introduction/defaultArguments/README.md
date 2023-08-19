# Argumentos padrão (Default arguments)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Argumentos padrão (Default arguments)](#argumentos-padrão-default-arguments)
  * [🔗 Tarefa](#-tarefa)
  * [Caso de uso](#caso-de-uso)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
  * [Índice de exercícios](#índice-de-exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Default%20arguments/Task.kt)

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

## Caso de uso

Os [`default arguments`](https://kotlinlang.org/docs/functions.html#default-arguments) é uma característica útil que permite que argumentos
sejam omitidos quando uma função é chamada, nesse caso,
o compilador usará os "default arguments" para cada argumento.

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

- **Menos Sobrecargas**: permite uma única função em vez de várias versões com diferentes argumentos.
- **Flexibilidade**: é possível chamar a função com diferentes combinações de argumentos, contanto que os obrigatórios sejam fornecidos.
- **Compatibilidade com Java**: funções com argumentos padrão são compatíveis com código Java, atuando como sobrecargas.

### Desvantagens

- **Complexidade do Código**: Quando utilizado em excesso, pode complicar a leitura e entendimento do código.
- **Descarte no Bytecode Java**: Em Java, os argumentos padrão do Kotlin não são reconhecidos, por isso devemos utilizar a
  anotação `@JvmOverloads` para utilizá-los.

---

## Analogia

No Brasil, o nome dado ao pão francês varia de cidade para cidade. Em Kotlin, da mesma forma, podemos ter valores padrão que diferem
conforme a configuração:

```kotlin
enum class TipoPao {
    FRANCÊS, CACETINHO, CARIOQUINHA,
    DE_SAL, CARECA, PÃOZINHO, JACÓ,
}

fun pedidoRecife(tipo: TipoPao = TipoPao.DE_SAL) = tipo.name
fun pedidoManaus(tipo: TipoPao = TipoPao.CARECA) = tipo.name
fun pedidoAracaju(tipo: TipoPao = TipoPao.JACÓ) = tipo.name
fun pedidoSaoPaulo(tipo: TipoPao = TipoPao.FRANCÊS) = tipo.name
fun pedidoBrasilia(tipo: TipoPao = TipoPao.PÃOZINHO) = tipo.name
fun pedidoFortaleza(tipo: TipoPao = TipoPao.CARIOQUINHA) = tipo.name
fun pedidoPortoAlegre(tipo: TipoPao = TipoPao.CACETINHO) = tipo.name
```
---

## Índice de exercícios

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
