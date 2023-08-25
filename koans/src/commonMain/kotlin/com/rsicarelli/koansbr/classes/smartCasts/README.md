# Tipagem inteligente (Smart casts)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->
* [Tipagem inteligente (Smart casts)](#tipagem-inteligente-smart-casts)
  * [🔗 Tarefa](#-tarefa)
  * [Casos de uso](#casos-de-uso)
    * [Verificação de tipo e inferência](#verificação-de-tipo-e-inferência)
      * [Verificação positiva](#verificação-positiva)
      * [Verificação negativa](#verificação-negativa)
      * [Limitações com variáveis mutáveis (`var`)](#limitações-com-variáveis-mutáveis-var)
    * [Smart Casts com operadores lógicos](#smart-casts-com-operadores-lógicos)
    * [Vantagens](#vantagens)
    * [Desvantagens](#desvantagens)
  * [Analogia](#analogia)
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

Em programação, cada tipo de dado é representado e operado diferentemente na memória. O "casting" é uma técnica usada para informar ao
compilador que uma variável deve ser tratada como outro tipo. Isso permite realizar operações específicas com essa variável, além de
garantir a compatibilidade com outras partes do código.

Em Kotlin, existe um recurso do compilador chamado **Smart casts** que rastreia verificações de tipos (como com o operador `is`) e infere
automaticamente o seu tipo quando necessário.

### Verificação de tipo e inferência

#### Verificação positiva

Ao verificar uma variável com o operador `is`, e se a verificação for bem-sucedida, Kotlin reconhece imediatamente o tipo dessa variável
dentro do bloco de código:

```kotlin
class Gato(val emojiGato: String = "🐱")
class Cachorro(val emojiCachoro: String = "🐶")
class Peixe(val emojiPeixe: String = "🐟")
class Pássaro(val emojiPassaro: String = "🐦")

fun falar(animal: Any): String {
    return when (animal) {
        is Gato -> "Miau ${animal.emojiGato}"
        is Cachorro -> "Au au ${animal.emojiCachoro}"
        is Peixe -> "Blub blub ${animal.emojiPeixe}"
        is Pássaro -> "Pi pi ${animal.emojiPassaro}"
        else -> "Não reconhecemos esse animal."
    }
}

fun ondeVive(animal: Any) {
    if (animal is Gato || animal is Cachorro) {
        println("Vive em terra.")
    } else if (animal is Peixe) {
        println("Vive na água.")
    } else if (animal is Pássaro) {
        println("Vive no ar e na terra.")
    } else {
        println("Não reconhecemos esse animal.")
    }
}
```

#### Verificação negativa

Usando `!` antes do operador `is`, é possível reagir quando a variável não é do tipo esperado:

```kotlin
class Ave(val canto: String)
class Macaco(val grito: String)
class Reptil(val som: String = "Ssssss")

fun documentarSom(animal: Any) {
    if (animal !is Ave) return

    print("O som da ave é: ${animal.canto}")
}

// Testando a função
val tucano = Ave("Pi-pi-piu")
documentarSom(tucano)  // Saída: "O som da ave é: Pi-pi-piu"
```

#### Limitações com variáveis mutáveis (`var`)

O compilador pode não realizar um Smart Cast se não
puder garantir que o valor da variável não mudou entre o momento da verificação e o momento do uso:

```kotlin
open class Animal
class Cachorro() : Animal() {
    fun alimentar() = Unit
}

var animal: Animal? = Cachorro()

if (animal is Cachorro) {
    animal = null
    animal.alimentar()  // Erro de compilação: Smart cast para 'Cachorro' é impossível
}
```

### Smart Casts com operadores lógicos

Kotlin vai além e integra a capacidade de "Smart Casts" com operadores lógicos como `&&` e `||`. Isso evita a necessidade de conversões
explícitas, tornando o código mais limpo e legível.

```kotlin
open class Animal(val nome: String, val energia: Int = 100)

class Peixe(nome: String, energia: Int, val habitatPreferido: String) : Animal(nome, energia) {
    fun explorar() = "está explorando o habitat $habitatPreferido!"
}

class Passaro(nome: String, energia: Int, val tipoBico: String) : Animal(nome, energia) {
    fun bicar() = "está usando seu bico $tipoBico para buscar comida!"
}

fun acaoEspecifica(animal: Animal) {
    when {
        animal is Peixe && animal.energia > 50 -> {
            println("${animal.nome} ${animal.explorar()}")
        }

        animal is Passaro && animal.tipoBico == "afiado" -> {
            println("${animal.nome} ${animal.bicar()}")
        }

        else -> {
            println("${animal.nome} não está realizando uma ação específica no momento.")
        }
    }
}

// Testando a função
val tilapia = Peixe("Tilápia", 60, "lago de água doce")
val aguia = Passaro("Águia", 80, "afiado")
val canario = Passaro("Canário", 50, "pequeno")

acaoEspecifica(tilapia)  // Saída: "Tilápia está explorando o habitat lago de água doce!"
acaoEspecifica(aguia)    // Saída: "Águia está usando seu bico afiado para buscar comida!"
acaoEspecifica(canario)  // Saída: "Canário não está realizando uma ação específica no momento."
```

### Vantagens

- **Sintaxe limpa e código legível**: permite um código mais limpo, direto e legível, evitando repetições de conversões explícitas de tipo.
- **Segurança de tipo**: o compilador realiza o Smart Cast apenas quando é seguro, reduzindo a possibilidade de erros de conversão em tempo
  de execução.
- **Integração com controle de fluxo**: dentro de controles condicionais como `if`, `else`, `when`, ou loops como `for`, `while`, o Kotlin
  reconhece e ajusta o tipo da variável de acordo, permitindo o acesso direto a suas propriedades específicas sem
  necessidade de casting explícito.

### Desvantagens

- **Limitações com Variáveis Mutáveis**: com variáveis mutáveis, Smart Casts pode não ser garantido pelo compilador, já que o tipo pode ter
  mudado entre a verificação e o uso.
- **Concorrência**: em ambientes com múltiplos threads, o Smart Cast pode apresentar riscos se uma variável for alterada por outro thread
  após a verificação.
- **Potencial confusão com lógica complexa**: em certas lógicas condicionais, o compilador pode não conseguir inferir o tipo, mesmo que
  pareça claro para o desenvolvedor.

## Analogia

Ao ouvir o canto de um pássaro específico na floresta, um ornitólogo pode identificar imediatamente a espécie, mesmo sem vê-la. Esse
reconhecimento imediato permite ao especialista saber tudo sobre esse pássaro, desde seus hábitos até seu habitat.

O Smart Cast no Kotlin age de forma semelhante, permitindo utilizar o tipo específico assim que identificado, sem necessidade de
verificações adicionais.

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
