## Nullable types

Em Kotlin, quando falamos sobre "tipos nulos", estamos nos referindo à capacidade de lidar com referências que podem não apontar para nenhum
objeto ("nulas"). A grande sacada é que essa possibilidade de nulidade deve ser especificada explicitamente no sistema de tipos.

Isso significa que, se você tiver uma variável que pode ser nula, você precisa indicar isso usando o ponto de interrogação `?` logo após o
tipo da variável:

```kotlin
var textoNullable: String? = null
```

Aprenda mais sobre [nullables e chamadas seguras](https://kotlinlang.org/docs/null-safety.html)

### Tarefa

Reescreva o código a seguir para que ele tenha apenas uma expressão `if`:
<details>
  <summary>Java</summary>

```java
public void com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(
    @Nullable com.rsicarelli.koansbr.introduction.nullableTypes.Client client,
    @Nullable String message,
    @NotNull com.rsicarelli.koansbr.introduction.nullableTypes.Mailer mailer
){
    if(client==null||message==null)return;
    
    com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo personalInfo=client.getPersonalInfo();
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
function com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(client, message, mailer) {
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
interface com.rsicarelli.koansbr.introduction.nullableTypes.Client {
    getPersonalInfo: () => com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo | null;
}

interface com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo {
    getEmail: () => string | null;
}

interface com.rsicarelli.koansbr.introduction.nullableTypes.Mailer {
    sendMessage: (email: string, message: string) => void;
}

function com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(client: com.rsicarelli.koansbr.introduction.nullableTypes.Client | null, message: string | null, mailer: com.rsicarelli.koansbr.introduction.nullableTypes.Mailer): void {
    if (client === null || message === null) return;

    const personalInfo: com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo | null = client.getPersonalInfo();
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
func com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(client: com.rsicarelli.koansbr.introduction.nullableTypes.Client?, message: String?, mailer: com.rsicarelli.koansbr.introduction.nullableTypes.Mailer) {
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

function com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient($client, $message, $mailer) {
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
void com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(com.rsicarelli.koansbr.introduction.nullableTypes.Client client, String message, com.rsicarelli.koansbr.introduction.nullableTypes.Mailer mailer) {
  if (client == null || message == null) return;

  com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo personalInfo = client.getPersonalInfo();
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
func com.rsicarelli.koansbr.introduction.nullableTypes.sendMessageToClient(client *com.rsicarelli.koansbr.introduction.nullableTypes.Client, message string, mailer *com.rsicarelli.koansbr.introduction.nullableTypes.Mailer) {
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

type com.rsicarelli.koansbr.introduction.nullableTypes.Client struct {
    personalInfo *com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo
}

func (c *com.rsicarelli.koansbr.introduction.nullableTypes.Client) getPersonalInfo() *com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo {
    return c.personalInfo
}

type com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo struct {
    email string
}

func (pi *com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo) getEmail() string {
    return pi.email
}

type com.rsicarelli.koansbr.introduction.nullableTypes.Mailer struct{}

func (m *com.rsicarelli.koansbr.introduction.nullableTypes.Mailer) sendMessage(email string, message string) {
    // lógica de envio de mensagem
}
```
</details>

<details>
  <summary>C#</summary>

```csharp
public void SendMessageToClient(
    com.rsicarelli.koansbr.introduction.nullableTypes.Client client,
    string message,
    com.rsicarelli.koansbr.introduction.nullableTypes.Mailer mailer
){
    if(client==null || message==null) return;
    
    com.rsicarelli.koansbr.introduction.nullableTypes.PersonalInfo personalInfo=client.GetPersonalInfo();
    if(personalInfo==null) return;
    
    string email=personalInfo.Email; 
    if(email==null) return;
    
    mailer.SendMessage(email, message);
}
```

</details>

### Caso de uso

Quando você tem uma variável que pode ser nula, você precisa usar a operação segura de chamada `?.` para acessar suas propriedades ou
métodos:

```kotlin
var textoNullable: String? = null
val tamanho: Int? = textoNulo?.length
println(tamanho) //null
```

Este é um recurso poderoso do Kotlin, pois elimina a possibilidade de ocorrer um erro de ponteiro
nulo ([`NullPointerException`](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html)) em tempo de execução, já que
se você
tentar acessar um membro (função ou atributo) de uma variável nullable sem ter certeza se não é nula, o compilador irá emitir um erro.

```kotlin
var textoNullable: String? = "Kotlin"
val tamanho: Int? = textoNulo?.length
println(tamanho) //6
```

Além disso, o Kotlin também inclui o operador [Elvis `?:`](https://kotlinlang.org/docs/null-safety.html#elvis-operator) que permite
especificar um valor fallback para usar quando o valor à esquerda for `null`:

```kotlin
var textoNullable: String? = null
var tamanho: Int = textoNullable?.length ?: 0
println(tamanho) //0

textoNullable = "Kotlin"
tamanho = textoNullable?.length ?: 0
println(tamanho) //6
```

#### Boas práticas

- **Use com Moderação**: Procure projetar seu código para evitar a necessidade de tipos nulos. Embora Kotlin lide bem com eles, o código
  tende a ser mais claro e simples sem o uso excessivo deles.
- **Defina Valores Padrão**: Se uma função pode retornar nulo, pense em um valor padrão sensato que possa ser usado. Por exemplo:

 ```kotlin
val elemento: String = list.find { ... } ?: ValorPadrao
```

- **Evitar !!**: O operador `!!` pode ser perigoso, pois força o uso de uma variável nullable e lança uma exceção se ela for nula. Tente
  evitar seu
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

#### Compatibilidade com Java

Kotlin trata a nulidade de forma diferente do Java, evitando muitos erros comuns. Ao usar código Java em Kotlin ou vice-versa, é importante
estar ciente das diferenças nos tipos nulos para evitar problemas de compilação.

Em Java, para expressar a nullabilidade de uma variável, precisamos das
anotações [`@Nullable`](https://javadoc.io/doc/org.jetbrains/annotations/20.1.0/org/jetbrains/annotations/Nullable.html)
e [`@NonNull`](https://www.javadoc.io/doc/com.google.code.findbugs/jsr305/latest/javax/annotation/Nonnull.html).

### Analogia

#### Nullables e caixas de presente

Imagine que cada variável em um programa é como uma caixa de presente. Essas caixas podem estar vazias, sem nenhum presente dentro, ou podem
conter um presente específico. Esses presentes representam os valores que as variáveis podem armazenar.

Quando a caixa de presente contém algo, podemos comparar isso a uma variável que contém um valor **não nulo**. É como ter um presente real e
tangível que você pode usar. Você sabe que tem algo útil e significativo para aproveitar.

Por outro lado, se a caixa de presente estiver vazia, isso é comparável a uma variável **nula** em Kotlin. Não há valor presente, o que
significa que a variável não está apontando para nada no momento. Assim como você não pode desfrutar de um presente que não está dentro da
caixa, você não pode realizar operações em uma variável nula sem tomar medidas especiais.

Em termos de programação, antes de tentar usar o valor de uma variável que pode ser nula, você deve verificar se há um valor presente, assim
como você verificará se há um presente dentro da caixa antes de entregá-lo para alguém. Isso é semelhante a usar a verificação de nulidade
no Kotlin.

Além disso, você pode pensar no operador Elvis (`?:`) como um presente reserva. Se a caixa estiver vazia, em vez de ficar desapontado, você
pode pegar um presente reserva que já estava preparado. Isso é comparável a atribuir um valor padrão a uma variável nula no Kotlin.