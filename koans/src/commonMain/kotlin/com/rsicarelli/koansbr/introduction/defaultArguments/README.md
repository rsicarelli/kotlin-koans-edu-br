## Default arguments

Em Kotlin, é possível ter [`default arguments`](https://kotlinlang.org/docs/functions.html#default-arguments) para os argumentos de uma
função.

Esta é uma característica útil que permite que argumentos sejam omitidos quando uma função é chamada, nesse caso, o compilador usará os
"default argument" para cada argumento.

## Tarefa

https://play.kotlinlang.org/koans/Introduction/Default%20arguments/Task.kt

Imagine que você tenha várias sobrecargas de `foo()` em na sua linguagem favorita:

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

Você pode substituir todas essas sobrecargas por uma única função em Kotlin.

Altere a declaração da função `foo` de forma que o código que usa `foo` seja compilado.

## Caso de uso

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

- **Menos sobrecarga de funções**: Em vez de criar várias versões da mesma função com diferentes listas de argumentos, podemos fornecer
  default arguments para alguns argumentos.
- **Flexibilidade ao chamar as funções**: Podemos chamar a mesma função com diferentes combinações de argumentos, enquanto todos os
  argumentos sem valor predefinido sejam fornecidos.
- **Código mais limpo e menos verboso**: O uso de argumentos predefinido ajuda a reduzir a quantidade de código que precisa ser escrita para
  atender a todos os casos de uso possíveis de uma função.
- **Compatibilidade total com Java**: Funções com argumentos predefinido podem ser chamadas a partir do código Java, como se fossem
  sobrecargas
  da mesma função.

### Desvantagens

- **Complexidade do código:** O uso excessivo de argumentos predefinido pode tornar o código mais difícil de ler e entender, especialmente
  para pessoas novatas.
- **Default arguments são descartados no bytecode Java:** Quando utilizamos funções do Java no Kotlin, os default arguments não estão
  disponíveis e cada combinação precisa ser sobrecarregada explicitamente na função `@JvmOverloads` para que os default arguments sejam
  usados.

### JVMOverloads

[`@JvmOverloads`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/) é uma anotação em Kotlin que instrui o compilador
a gerar sobrecargas de uma função (ou construtor) para cada combinação de argumentos com default arguments.

Em Kotlin, é possível definir default arguments para argumentos de funções, evitando a necessidade de criar múltiplas sobrecargas da mesma
função. No entanto, esse conceito não existe em Java da mesma forma que existe em Kotlin. Portanto, se você quiser chamar uma função Kotlin
com argumentos predefinido a partir do código Java, pode encontrar problemas.

A anotação `@JvmOverloads` resolve esse problema gerando sobrecargas adequadas para o código Java.

```kotlin
@JvmOverloads
fun displayMessage(message: String, times: Int = 1, prefix: String = "") {
    for (i in 1..times) {
        println("$prefix$message")
    }
}
```

Ao adicionar a anotação `@JvmOverloads`, o compilador Kotlin gerará as seguintes sobrecargas (para uso em Java):

```java
void displayMessage(String message){...}
        void displayMessage(String message,int times){...}
        void displayMessage(String message,int times,String prefix){...}
```

Dessa forma, o código Java pode chamar qualquer uma dessas sobrecargas, dependendo de quantos argumentos a pessoa programadora deseja
fornecer.

### Analogia

#### Padaria e default arguments

Imagine que você vá a uma padaria famosa pelo seu café da manhã chamado "Café Padrão". Esse "Café Padrão" é simplesmente um café preto
médio, sem adições.

No entanto, a padaria reconhece que nem todos gostam do café preto puro. Algumas pessoas podem querer alguma bebida vegetal, açúcar,
caramelo, chantilly, entre outros.

Mas se um cliente entra e simplesmente diz: "Quero um café", sem dar mais detalhes, o atendente entregará o "Café Padrão" (café preto
médio), porque esse é o predefinido.

Agora, pense nos default arguments em Kotlin da mesma maneira. Ao definir uma função, você pode estabelecer alguns default arguments para
certos argumentos. Se alguém chamar essa função sem fornecer detalhes para esses argumentos, os default arguments são usados.

Por exemplo, você pode ter uma função assim:

```kotlin
fun pedirCafe(tamanho: String = "médio", adicional: String? = null) {
    // prepara o café
}

pedirCafe()
```

Você receberá um café médio sem adições, pois são os default arguments.

Mas, se você quiser algo diferente, pode ser específico:

```kotlin
pedirCafe("grande", "com caramelo e chantilly")
```

E aí, você receberá um café grande com caramelo e chantilly!
