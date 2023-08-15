## Nullable types

Learn about
[null safety and safe calls](https://kotlinlang.org/docs/null-safety.html)

### Tarefa

Reescreva o código a seguir para que ele tenha apenas uma expressão `if`:
<details>
  <summary>Java</summary>

```java
public void sendMessageToClient(
    @Nullable Client client,
    @Nullable String message,
    @NotNull Mailer mailer
){
    if(client==null||message==null)return;
    
    PersonalInfo personalInfo=client.getPersonalInfo();
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

### Caso de uso

Em Kotlin, as referências nulas são controladas pelo sistema de tipos. Isso significa que a possibilidade de uma variável ser nula (ou seja,
que pode ser objeto ou nenhum objeto) deve ser explicitamente especificada.

Qualquer variável que pode ser nula deve ser marcada com um ponto de interrogação `?` logo após a sua declaração de tipo, indicando que ela
pode manter uma referência nula além dos valores normais do tipo.

```kotlin
var stringNula: String? = null
```

O compilador Kotlin vai gerar um erro, impossibilitando que variáveis não nullable contenham valores nulos.

Este é um recurso poderoso do Kotlin, pois elimina a possibilidade de ocorrer um erro de ponteiro nulo em tempo de execução, já que se você
tentar acessar um membro (função ou atributo) de uma variável nullable sem ter certeza se não é nula, o compilador irá emitir um erro.

Para acessar de maneira segura métodos ou propriedades em variáveis sob tipo nullable, Kotlin oferece a operação segura de chamada `?.`:

```kotlin
//tamanho pode ser null
val tamanho: Int? = stringNula?.length 
```

O valor resultante será `null` se `stringNula` for nula ou o tamanho da string caso `stringNula` tenha sido inicializada.

Além disso, o Kotlin também inclui o operador [Elvis `?:`](https://kotlinlang.org/docs/null-safety.html#elvis-operator) que permite
especificar um valor fallback para usar quando o valor à esquerda for null:

```kotlin
//resultado não é mais nulo, pois temos um valor predefinido
val tamanho: Int = stringNula?.length ?: 0 
```

Neste exemplo, o tamanho da string será atribuído a `tamanho` se `stringNula` não for nula e `0` caso `stringNula` tenha conteúdo. Ou seja,
teremos garantia que essa variável nunca será nula, possibilitando utiliza-la de maneira segura nas próximas linhas.

#### Boas práticas

- **Modere o uso de nullables**: Sempre que possível, tente projetar seu código para reduzir a necessidade de usar os nullables. Embora
  Kotlin lide com nullables de forma bem elegante, o código geralmente fica mais limpo e mais simples sem eles.
- **Usar valores padrão**: Se uma função pode retornar um valor nulo, considere se há um valor padrão sensato que você possa retornar. Por
  exemplo

 ```kotlin
val elemento: String = list.find { ... } ?: DefaultValue
```

- **Evitar !!**: O operador `!!` é perigoso, pois força o uso de uma variável nullable e lança uma exceção se ela for nula. Tente evitar seu
  uso sempre que possível e optar por manipulação segura de nulos.
- **Usar [let](https://kotlinlang.org/docs/scope-functions.html#let), [run](https://kotlinlang.org/docs/scope-functions.html#run)
  e [also](https://kotlinlang.org/docs/scope-functions.html#also) para trabalhar com nullables**: Eles fornecem maneiras idiomáticas de
  trabalhar com nullables e podem ajudar a tornar o código mais compacto e legível.
- **Use declarações `if` para verificações de nulidade**: Graças aos [smart casts](https://kotlinlang.org/docs/typecasts.html#smart-casts)
  do Kotlin, se você verificar a nulidade de uma variável usando `if`, então dentro desse bloco `if` você pode usar a variável como se ela
  fosse não-nula.
- **Usar tipos não nullables quando possível**: Se um valor nunca deveria ser nulo durante o ciclo de vida normal de um programa, deve ser
  um tipo não nullable.
- **Manter as verificações de nulidade simples**: Verificações de nulidade complexas levam a código desnecessariamente complicado. Tente
  mantê-los o mais simples possível.

#### Compabitilidade com Java
Em Java, todas as referências de objeto podem, por padrão, ser nulas. No entanto, isso também significa que `NullPointerExceptions` - um tipo comum de bug de tempo de execução - são uma preocupação constante.

Kotlin, por outro lado, diferencia entre os tipos de referência que podem conter null (nullables, marcados com `?`) e aqueles que não podem. Isto torna claro quando você precisa verificar a nulidade, o que pode ajudar a prevenir `NullPointerExceptions`.

Quando você chama código Java a partir de Kotlin, as referências podem ser de um tipo nullable ou não-nullable, dependendo das anotações Java utilizadas. Se estas anotações não estiverem presentes, então um tipo chamado plataforma é utilizado. O tipo plataforma parece um tipo não-nullable, mas não força a verificação de nulidade, permitindo que você possa, inadvertidamente, causar um `NullPointerException`.

Por exemplo, se você tiver uma `String` em Java, ela será vista como sendo do tipo `String!` em Kotlin, o que significa que poderia ser tanto uma `String` nullable como uma `String` não-nullable. Nesses casos, é uma boa prática tratar os tipos da plataforma como se fossem nullables para evitar erros potenciais.

Quando você chama código Kotlin a partir de Java, tipos nullables em Kotlin aparecem como tipos normais em Java. Contudo, graças às anotações `@Nullable`e `@NonNull`, qualquer tentativa de passar ou retornar uma referência nula onde não é esperado causa um aviso de compilador.
