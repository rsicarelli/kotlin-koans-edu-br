# Tipos anuláveis (Nullable types)

<details>
<summary>&nbsp;<b>Conteúdo</b> (clique para expandir)</summary>

<p></p>

<!-- TOC -->

* [Tipos anuláveis (Nullable types)](#tipos-anuláveis-nullable-types)
    * [🔗 Tarefa](#-tarefa)
    * [Caso de uso](#caso-de-uso)
        * [Kotlin gerenciando variáveis que podem ser nulas](#kotlin-gerenciando-variáveis-que-podem-ser-nulas)
        * [O operador "Elvis" `?:`](#o-operador-elvis-)
        * [Burlando a Nulabilidade em Kotlin](#burlando-a-nulabilidade-em-kotlin)
            * [Operador `!!`](#operador-)
            * [Utilizando `lateinit`](#utilizando-lateinit)
            * [Use com cuidado](#use-com-cuidado)
    * [Boas práticas](#boas-práticas)
    * [Analogia](#analogia)
        * [Nullables e caixas de presente](#nullables-e-caixas-de-presente)
    * [Exercícios](#exercícios)

<!-- TOC -->

</details>

## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Introduction/Nullable%20types/Task.kt)

Reescreva o código a seguir para que ele tenha apenas uma expressão `if`:
<details>
  <summary>Java</summary>

```java
package main

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public void sendMessageToClient(
@Nullable Client client,
@Nullable String message,
@NotNull Mailer mailer
        ){
        if(client==null||message==null)return;

        PersonalInfoJava personalInfo=client.getPersonalInfo();
        if(personalInfo==null)return;

        String email=personalInfo.getEmail();
        if(email==null)return;

        mailer.sendMessage(email,message);
        }
```

</details>
<details>
  <summary>JavaScript</summary>

```javascript
function sendMessageToClient(client, message, mailer) {
    if (client === null || message === null) return;

    const personalInfo = client.getPersonalInfo();
    if (personalInfo === null) return;

    const email = personalInfo.getEmail();
    if (email === null) return;

    mailer.sendMessage(email, message);
}
```

</details>

<details>
  <summary>TypeScript</summary>

```typescript
interface Client {
    getPersonalInfo: () => PersonalInfo | null;
}

interface PersonalInfo {
    getEmail: () => string | null;
}

interface Mailer {
    sendMessage: (email: string, message: string) => void;
}

function sendMessageToClient(client: Client | null, message: string | null, mailer: Mailer): void {
    if (client === null || message === null) return;

    const personalInfo: PersonalInfo | null = client.getPersonalInfo();
    if (personalInfo === null) return;

    const email: string | null = personalInfo.getEmail();
    if (email === null) return;

    mailer.sendMessage(email, message);
}
```

</details>

<details>
  <summary>Python</summary>

```python
def send_message_to_client(client, message, mailer):
    if client is None or message is None:
        return

    personal_info = client.get_personal_info()
    if personal_info is None:
        return

    email = personal_info.get_email()
    if email is None:
        return

    mailer.send_message(email, message)
```

</details>

<details>
  <summary>Swift</summary>

```swift
func sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    guard let client = client, let message = message else { return }

    guard let personalInfo = client.getPersonalInfo() else { return }

    guard let email = personalInfo.getEmail() else { return }

    mailer.sendMessage(email: email, message: message)
}
```

</details>

<details>
  <summary>PHP</summary>

```injectablephp
<?php

function sendMessageToClient($client, $message, $mailer) {
    if($client === null || $message === null) {
        return;
    }

    $personalInfo = $client->getPersonalInfo();
    if($personalInfo === null) {
        return;
    }

    $email = $personalInfo->getEmail();
    if($email === null) {
        return;
    }

    $mailer->sendMessage($email, $message);
}
?>
```

</details>

<details>
  <summary>Dart</summary>

```dart
void sendMessageToClient(Client client, String message, Mailer mailer) {
  if (client == null || message == null) return;

  PersonalInfo personalInfo = client.getPersonalInfo();
  if (personalInfo == null) return;

  String email = personalInfo.getEmail();
  if (email == null) return;

  mailer.sendMessage(email, message);
}
```

</details>

<details>
  <summary>Go</summary>

```go
package main

func sendMessageToClient(client *Client, message string, mailer *Mailer) {
	if client == nil || message == "" {
		return
	}

	personalInfo := client.getPersonalInfo()
	if personalInfo == nil {
		return
	}

	email := personalInfo.getEmail()
	if email == "" {
		return
	}

	mailer.sendMessage(email, message)
}

type Client struct {
	personalInfo *PersonalInfo
}

func (c *Client) getPersonalInfo() *PersonalInfo {
	return c.personalInfo
}

type PersonalInfo struct {
	email string
}

func (pi *PersonalInfo) getEmail() string {
	return pi.email
}

type Mailer struct{}

func (m *Mailer) sendMessage(email string, message string) {
	// lógica de envio de mensagem
}

```

</details>

<details>
  <summary>C#</summary>

```csharp
public void SendMessageToClient(
    Client client,
    string message,
    Mailer mailer
){
    if(client==null || message==null) return;
    
    PersonalInfo personalInfo=client.GetPersonalInfo();
    if(personalInfo==null) return;
    
    string email=personalInfo.Email; 
    if(email==null) return;
    
    mailer.SendMessage(email, message);
}
```

</details>

## Caso de uso

No mundo da programação, é comum encontrar situações em que variáveis não possuem um valor atribuído, sendo identificadas como "nulas".

Em Kotlin, os tipos anuláveis permitem que variáveis possam ou não ter um valor. Essa característica traz uma camada extra de segurança ao
código, garantindo que a possibilidade de um valor ser nulo seja sempre explicitamente sinalizada.

### Kotlin gerenciando variáveis que podem ser nulas

Em Kotlin, sempre que uma variável tem potencial para ser nula, a linguagem sugere a adição de um `?` logo após o tipo da variável.

```kotlin
val textoNulo: String? = null
```

Para ter uma garantia que a variável não é nula, podemos utilizar a operação `?.` para acessar membros dessa variável

```kotlin
val tamanho: Int? = textoNulo?.length
```

### O operador "Elvis" `?:`

A ideia é que o operador Elvis fornece um valor "fallback" ou padrão se o valor à sua esquerda for `null`

Esse operador é extremamente útil para definir valores padrões e garantir que você não está lidando com valores nulos.

```kotlin
var tamanho: Int = textoNulo?.length ?: 0
```

> Se você inclinar a cabeça para o lado esquerdo, o símbolo `?:` parece os olhos e a mecha de cabelo característica de Elvis Presley.

### Burlando a Nulabilidade em Kotlin

Por mais que Kotlin lide com nulabilidade de forma segura, há momentos em que é preciso contornar essa segurança por várias razões, como ao
integrar com bibliotecas Java ou por outros requisitos específicos.

#### Operador `!!`

Ao ter certeza de que uma variável nullable não é nula, é possível usar o operador `!!` para forçar o tratamento da variável como não
nula. No entanto, se a variável for realmente nula, o programa lançará uma `NullPointerException`.

```kotlin
val nome: String? = obterNome()
val tamanho = nome!!.length  // Atenção! Isso pode lançar NullPointerException.
```

#### Utilizando `lateinit`

Se uma variável deve ser inicializada posteriormente, pode-se usar o modificador `lateinit`, que informa ao compilador que essa variável
será inicializada antes de seu acesso, evitando a necessidade de torná-la nullable.

No entanto, se tentarem acessá-la antes da sua inicialização, ocorrerá uma `UninitializedPropertyAccessException`.

```kotlin
lateinit var nome: String

println(nome) // Atenção! Isso pode lançar UninitializedPropertyAccessException.

fun inicializar() {
    nome = "Kotlin"
}
```

## Boas práticas

1. **Minimizar o uso:** se há certeza de que uma variável nunca será nula, é aconselhável defini-la como não anulável. Isso
   simplifica o código e minimiza possíveis erros.
2. **Prudência no uso do Elvis `?:`**:  crucial ter certeza de que o valor padrão faça sentido no contexto da expressão.
3. **Priorizar `?.` ao invés de `!!`**: ao invés de forçar uma variável a ser tratada como não nula com `!!`, é benéfico optar pelo `?.` e
   modelar seu código com uma tipagem segura.
4. **Cuidado ao utilizar `lateinit`**: seu uso imprudente pode ser arriscado. É vital garantir a inicialização da variável antes de
   acessá-la.
5. **Testar rigorosamente**: Ao desenvolver testes, é essencial cobrir cenários em que variáveis possam ser nulas. Isso ajuda a identificar
   potenciais problemas ainda na fase de desenvolvimento.

## Analogia

Uma caixa de correios pode ou não conter encomendas, assim como uma variável em Kotlin: em alguns dias ela contém uma encomenda (um valor) e
em outros, está vazia (nula).

Da mesma forma que alguém verifica a caixa antes de pegar uma encomenda, em Kotlin, o `?` sinaliza a possibilidade da "caixa" estar vazia.

```kotlin
val encomenda: Encomenda? = checarCaixaDeCorreio()
val remetente: String? = encomenda?.remetente

if (remetente == null || encomenda == null) {
    println("Ainda não chegou")
}
```

---

## Exercícios

1. [Olá, mundo! (Hello, world!)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/helloWorld/README.md)
2. [Argumentos nomeados (Named arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/namedArguments/README.md)
3. [Argumentos padrão (Default arguments)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/defaultArguments/README.md)
4. [Strings com três aspas (Triple-quoted strings)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/tripleQuotedStrings/README.md)
5. [Modelos de string (String templates)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/stringTemplates/README.md)
6. **➡️ [Tipos anuláveis (Nullable types)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nullableTypes/README.md
   )**
7. [Tipo "nenhum" (Nothing type)](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/nothingType/README.md)
8. [Lambdas](https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/introduction/lambdas/README.md)
