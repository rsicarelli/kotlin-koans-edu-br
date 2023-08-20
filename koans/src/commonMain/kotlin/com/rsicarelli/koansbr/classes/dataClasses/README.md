## Data classes

As [Data Classes](https://kotlinlang.org/docs/data-classes.html) no Kotlin são uma maneira concisa de criar classes que apenas mantêm dados.
Elas automaticamente fornecem métodos úteis,
como `equals()`, `hashCode()`, `toString()`, `copy()` e `.componentN()`. Isso ajuda a reduzir a verbosidade do código

As data classes são uma parte muito útil e poderosa do Kotlin, sendo usadas frequentemente para casos em que você precisa armazenar dados,
mas não precisa de muita lógica ou comportamento adicional na classe.

### Tarefa

https://play.kotlinlang.org/koans/Classes/Data%20classes/Task.kt

Reescreva o seguinte código para Kotlin:
<details>
  <summary>Java</summary>

```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

</details>
<details>
  <summary>JavaScript</summary>

```javascript
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    getName() {
        return this.name;
    }

    getAge() {
        return this.age;
    }
}
```

</details>

<details>
  <summary>TypeScript</summary>

```typescript
class Person {
    readonly name: string;
    readonly age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    getName(): string {
        return this.name;
    }

    getAge(): number {
        return this.age;
    }
}
```

</details>

<details>
  <summary>Python</summary>

```python
class Person:
    def __init__(self, name, age):
        self._name = name
        self._age = age

    @property
    def name(self):
        return self._name

    @property
    def age(self):
        return self._age
```

</details>

<details>
  <summary>Swift</summary>

```swift
struct Person {
    let name: String
    let age: Int
}
```

</details>

<details>
  <summary>PHP</summary>

```injectablephp
class Person {
    public function __construct(private string $name, private int $age) {}

    public function getName(): string {
        return $this->name;
    }
    public function getAge(): int {
        return $this->age;
    }
}
```

</details>

<details>
  <summary>Dart</summary>

```dart
class Person {
  final String name;
  final int age;

  Person(this.name, this.age);
}
```

</details>

<details>
  <summary>Go</summary>

```go
type Person struct {
    Name string
    Age  int
}

func NewPerson(name string, age int) *Person {
    return &Person{name, age}
}
```

</details>
<details>
  <summary>C#</summary>

```csharp
public class Person 
{
    public string Name { get; }
    public int Age { get; }

    public Person(string name, int age) 
    {
        Name = name;
        Age = age;
    }
}
```

</details>

Em seguida, adicione o modificador `data` à classe resultante.

### Caso de uso

```kotlin
data class Pessoa(
    val nome: String,
    val idade: Int,
)
```

Com apenas essa linha de código, você pode fazer o seguinte:

```kotlin
val joao = Pessoa("João", 30)
val maria = Pessoa("Maria", 30)

// Comparações
println(joao == maria) // false

val joao2 = joao.copy()
println(joao == joao2) // true

// toString()
println(joao) // Pessoa(nome=João, idade=30)

// copy()
val maria2 = maria.copy(idade = 31)
println(maria2) // Pessoa(nome=Maria, idade=31)
```

### Vantagens

- **Sintaxe curta**: Menos código necessário para definir classes de armazenamento de dados.
- **Métodos automáticos**: `equals()`, `hashCode()`, `toString()`, `copy()` são gerados sem esforço.
- **Desestruturação**: Suporte para decompor objetos em variáveis.

### Desvantagens

- **Focado em dados**: Menos apropriadas para classes que requerem comportamento complexo.
- **Extensibilidade restrita**: Data classes não podem herdar de outras classes de dados.
- **Métodos automáticos podem ser inflexíveis**: `equals()` e `hashCode()` se usam a todas as propriedades, podendo não ser desejado.

### Testabilidade

- Alterações nas propriedades da data class afetam os métodos `equals()`, `hashCode()`, o que pode impactar os seus testes.
- O método `copy()` facilita a criação de versões modificadas de objetos para testes.
- Data classes imutáveis (quando as suas propriedades são `val`) garantem que não haja efeitos colaterais indesejados.
