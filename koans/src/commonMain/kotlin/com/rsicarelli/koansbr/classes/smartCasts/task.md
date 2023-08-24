# Tipagem inteligente (Smart casts)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Tipagem inteligente (Smart casts)](#tipagem-inteligente-smart-casts)
  * [🔗 Tarefa](#-tarefa)
  * [Casos de uso](#casos-de-uso)
    * [Tipo dinâmico após verificação de tipo](#tipo-dinâmico-após-verificação-de-tipo)
      * [Verificação positiva](#verificação-positiva)
      * [Verificação negativa](#verificação-negativa)
    * [Smart Casts com operadores lógicos](#smart-casts-com-operadores-lógicos)
  * [Índice de exercícios](#índice-de-exercícios)
<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Classes/Smart%20casts/Task.kt)

Reescreva o código fornecido usando [smart casts](https://kotlinlang.org/docs/typecasts.html#smart-casts) e a
expressão [when](https://kotlinlang.org/docs/control-flow.html#when-expression) do Kotlin.

<details>
  <summary>Java</summary>

```java
class Java {
    public int eval(Expr expr) {
        if (expr instanceof Num) {
            return ((Num) expr).getValue();
        }
        if (expr instanceof Sum) {
            Sum sum = (Sum) expr;
            return eval(sum.getLeft()) + eval(sum.getRight());
        }
        throw new IllegalArgumentException("Unknown expression");
    }
}
```

</details>

<details>
  <summary>C#</summary>

```csharp
public interface Expr { }

public class Num : Expr
{
    public int Value { get; set; }
}

public class Sum : Expr
{
    public Expr Left { get; set; }
    public Expr Right { get; set; }
}

public int Eval(Expr expr)
{
    if (expr is Num num)
        return num.Value;

    if (expr is Sum sum)
        return Eval(sum.Left) + Eval(sum.Right);

    throw new ArgumentException("Unknown expression");
}
```

</details>

<details>
  <summary>Dart</summary>

```dart
abstract class Expr {}

class Num implements Expr {
  final int value;

  Num(this.value);
}

class Sum implements Expr {
  final Expr left, right;

  Sum(this.left, this.right);
}

int eval(Expr expr) {
  if (expr is Num) return expr.value;
  if (expr is Sum) return eval(expr.left) + eval(expr.right);
  throw ArgumentError('Unknown expression');
}
```

</details>

<details>
  <summary>Go</summary>

```go
package main

type Expr interface{}

type Num struct {
	Value int
}

type Sum struct {
	Left, Right Expr
}

func Eval(expr Expr) int {
	switch e := expr.(type) {
	case Num:
		return e.Value
	case Sum:
		return Eval(e.Left) + Eval(e.Right)
	default:
		panic("Unknown expression")
	}
}

```

</details>

<details>
  <summary>JavaScript</summary>

```javascript
function eval(expr) {
    if (expr instanceof Num) {
        return expr.value;
    }
    if (expr instanceof Sum) {
        return eval(expr.left) + eval(expr.right);
    }
    throw new Error("Unknown expression");
}

class Num {
    constructor(value) {
        this.value = value;
    }
}

class Sum {
    constructor(left, right) {
        this.left = left;
        this.right = right;
    }
}
```

</details>

<details>
  <summary>TypeScript</summary>

```typescript
interface Expr {
}

class Num implements Expr {
    constructor(public value: number) {
    }
}

class Sum implements Expr {
    constructor(public left: Expr, public right: Expr) {
    }
}

function eval(expr: Expr): number {
    if (expr instanceof Num) return expr.value;
    if (expr instanceof Sum) return eval(expr.left) + eval(expr.right);
    throw new Error("Unknown expression");
}
```

</details>

<details>
  <summary>PHP</summary>

```injectablephp
interface Expr {}

class Num implements Expr {
    public $value;
    function __construct($value) { $this->value = $value; }
}

class Sum implements Expr {
    public $left, $right;
    function __construct($left, $right) { $this->left = $left; $this->right = $right; }
}

function evalExpr($expr) {
    if ($expr instanceof Num) return $expr->value;
    if ($expr instanceof Sum) return evalExpr($expr->left) + evalExpr($expr->right);
    throw new Exception("Unknown expression");
}
```

</details>


<details>
  <summary>Python</summary>

```python
class Expr:
    pass


class Num(Expr):
    def __init__(self, value):
        self.value = value


class Sum(Expr):
    def __init__(self, left, right):
        self.left = left
        self.right = right


def eval_expr(expr):
    if isinstance(expr, Num):
        return expr.value
    if isinstance(expr, Sum):
        return eval_expr(expr.left) + eval_expr(expr.right)
    raise ValueError("Unknown expression")
```

</details>

<details>
  <summary>Swift</summary>

```swift
protocol Expr {}

class Num: Expr {
    let value: Int
    init(_ value: Int) { self.value = value }
}

class Sum: Expr {
    let left, right: Expr
    init(_ left: Expr, _ right: Expr) { self.left = left; self.right = right }
}

func eval(_ expr: Expr) -> Int {
    if let num = expr as? Num {
        return num.value
    }
    if let sum = expr as? Sum {
        return eval(sum.left) + eval(sum.right)
    }
    fatalError("Unknown expression")
}
```

</details>

---

## Casos de uso

Em muitas linguagens de programação, é comum a necessidade de se fazer um "casting" (ou "conversão de tipo") de uma variável para outro
tipo.

Em Kotlin, existe um recurso do compilador chamado **Smart casts** que rastreia verificações de tipos (como com o operador `is`) e infere
automaticamente o seu tipo quando necessário.

### Tipo dinâmico após verificação de tipo

#### Verificação positiva

Quando você verifica uma variável com `is`, se essa verificação for positiva, Kotlin automaticamente entende o tipo daquela variável naquele
bloco de código:

```kotlin
class Felino(val emoji : String = "🐱")
class Canino(val emoji : String = "🐶")

fun falar(animal: Any) {
    if (animal is Felino) println("Miau $emoji") 
    if (animal is Canino) println("Au au $emoji")
}
```

#### Verificação negativa

Adicionando-se um `!` antes do `is`, permite-se executar uma ação caso o tipo da variável não seja o esperado

```kotlin
if (animal !is Felino) return

print("O nome do felino é ${animal.nome}") 
```

### Smart Casts com operadores lógicos

Em Kotlin, ao usar operadores lógicos como `&&` (E) ou `||` (OU), a verificação (ou sua negação) de tipo no lado esquerdo do
operador também pode influenciar o tipo inferido do lado direito.

Isso é extremamente útil para evitar casts explícitos e tornar o código mais legível, flúido e eliminar verbosidade.

```kotlin
// Após o ||, a variável é considerada do tipo "Cachorro" e tem acesso a atributos especiais de classe
if (animal !is Cachorro || animal.nome.isEmpty()) return
```

```kotlin
// Similarmente, após o &&, a variável tem seu tipo inferido, sem necessidade de expressar seu tipo 
if (animal is Cachorro && animal.nome.isNotEmpty()) {
    println("O nome do cachorro é ${animal.nome}")
}
```

## Índice de exercícios

1. [Classes de Dados (Data Classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/dataClasses/README.md
   )

2. ➡️ **[Tipagem inteligente (Smart casts)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/smartCasts/README.md
   )**

3. [Classes seladas (Sealed classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/sealedClasses/README.md
   )

4. [Renomear ao importar (Rename on import)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/renameOnImport/README.md
   )

5. [Funções de extensão (Extension functions)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/extensionFunctions/README.md
   )
