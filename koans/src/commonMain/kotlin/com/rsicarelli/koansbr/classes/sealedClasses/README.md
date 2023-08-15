## Sealed classes

[Sealed Classes e Interfaces](https://kotlinlang.org/docs/sealed-classes.html) em Kotlin são um recurso especial para criar um conjunto
específico e limitado de classes relacionadas. São como caixas que
contêm opções predefinidas e não permitem a criação de novas opções fora desse conjunto. Isso traz segurança e controle ao código, evitando
erros e simplificando a compreensão.

```kotlin
sealed class InstrumentoMusical(
    val nome: String,
    val tipo: TipoInstrumento,
) {
    data class Violao(val cordas: Int) : InstrumentoMusical("violão", Corda)
    data class Bateria(val tambores: Int) : InstrumentoMusical("bateria", Percussao)
    data class Piano(val teclas: Int) : InstrumentoMusical("piano", Tecla)
}

sealed interface TipoInstrumento
data object Corda : TipoInstrumento
data object Percussao : TipoInstrumento
data object Tecla : TipoInstrumento
```

### Tarefa

https://play.kotlinlang.org/koans/Classes/Sealed%20classes/Task.kt

Reutilize sua solução da tarefa anterior, mas substitua a interface
pela interface [`sealed`](https://kotlinlang.org/docs/sealed-classes.html).
Assim, você não precisará mais do bloco `else` na expressão `when`.

### Casos de uso

#### Qual Problema as Sealed Classes Resolvem?

As Sealed Classes resolvem o problema de representar um conjunto limitado e específico de estados ou tipos em uma hierarquia de classes ou
interfaces. Elas garantem que apenas um conjunto predefinido de subclasses seja criado, evitando a introdução acidental de novos estados ou
tipos que não façam sentido no contexto. Isso significa que, outros arquivos não poderão herdar suas `sealed` classes, apenas onde ela for
declarada.

Isso é especialmente útil quando você precisa lidar com situações em que só um número limitado de variações é válido. Por exemplo, em um
aplicativo de processamento de pagamentos, as Sealed Classes poderiam ser usadas para representar diferentes estados de pagamento,
como `Aprovado > Recusado > Pendente`. Dessa forma, você tem um controle rigoroso sobre os estados possíveis e evita inconsistências no
código.

#### Relação das Sealed Classes com Enums

Enquanto Enums são usados para representar um conjunto fixo de valores constantes, as Sealed Classes podem representar um conjunto de tipos
complexos com estados e comportamentos variados.

As principais diferenças são:

- **Hierarquia de Classes**: Enquanto Enums são uma lista plana de valores constantes, as Sealed Classes são uma hierarquia de classes. Isso
  significa que cada subclasse de uma Sealed Class pode ter propriedades e métodos específicos, proporcionando mais flexibilidade para
  modelar situações complexas.

```kotlin
sealed interface Reino
data class Animalia(val classes: List<String>) : Reino
data class Plantae(val familias: List<String>) : Reino

sealed class Habitat(val descricao: String)
data object Terrestre : Habitat("na terra")
data object Aquatico : Habitat("na água")
data object Aereo : Habitat("no ar")

sealed class Organismo(val nome: String) {
    data class Animal(val especie: String) : Organismo("Animal")
    data class Planta(val tipo: String) : Organismo("Planta")
    data object Microorganismo : Organismo("Microorganismo") {
        const val descrição: String = "Pequeno e unicelular"
    }
}

fun detalhes(organismo: Organismo, reino: Reino, habitat: Habitat): String {
    return when (organismo) {
        is Animal -> "Um $nome da espécie $especie pertencente ao reino $reino e vive $habitat."
        is Planta -> "Uma $nome do tipo $tipo pertencente ao reino $reino e vive $habitat."
        is Microorganismo -> "Um $nome - $descrição - pertencente ao reino $reino e vive $habitat."
    }
}
```

- **Agrupamento de Dados e Comportamentos**: Sealed Classes podem agrupar não apenas valores, mas também comportamentos específicos
  relacionados a cada estado ou tipo. Isso é vantajoso quando você precisa que cada estado ou tipo tenha métodos personalizados.

```kotlin
sealed class FormaGeometrica {
    data class Circulo(val raio: Double) : FormaGeometrica()
    data class Retangulo(
        val largura: Double,
        val altura: Double,
    ) : FormaGeometrica()

    fun calcularArea(): Double = when (this) {
        is Circulo -> kotlin.math.PI * raio * raio
        is Retangulo -> largura * altura
    }
}

val main {
    Circulo(5.0).calcularArea() == 78.53981633974483
    Retangulo(3.0, 4.0).calcularArea() == 12.0
}
```

- **Casos de Uso Mais Complexos**: Enquanto Enums são ideais para representar conjuntos simples de valores, as Sealed Classes são mais
  adequadas
  para casos de uso mais complexos, como modelar estados, tipos alternativos ou padrões de herança.

```kotlin
sealed class ResultadoOperacao {
    object Sucesso : ResultadoOperacao()
    data class Erro(
        val codigo: Int,
        val mensagem: String,
    ) : ResultadoOperacao()
}

fun main() {
    val sucesso: ResultadoOperacao = Sucesso
    val erro: ResultadoOperacao = Erro(404, "Página não encontrada")
}
```

- **Controle Exclusivo**: Sealed Classes permitem um controle mais estrito sobre as subclasses permitidas. Cada caso da classe selada pode
  ter
  suas próprias subclasses, enquanto em Enums todos os casos compartilham a mesma estrutura.

```kotlin
sealed interface DiaDaSemana {
    object Segunda : DiaDaSemana
    object Terca : DiaDaSemana
    object Quarta : DiaDaSemana
    object Quinta : DiaDaSemana
    object Sexta : DiaDaSemana
    object Sabado : DiaDaSemana
    object Domingo : DiaDaSemana
}

fun main() {
    require(Segunda is DiaDaSemana)
    require(Sexta is DiaDaSemana)
    require(Segunda is Sexta) // Não é verdade que Segunda é Sexta
}
```

#### Sealed na Programação Funcional

A programação funcional enfatiza a composição de funções e o tratamento de dados imutáveis. Sealed Classes são usadas para definir
estruturas de dados com estados limitados e previsíveis, seguindo os princípios da imutabilidade. Isso significa que, uma vez que um estado
é definido por uma Sealed Class, ele não pode ser alterado diretamente - qualquer transformação resulta na criação de uma nova instância.

A combinação de programação funcional e Sealed Classes promove a clareza, evita efeitos colaterais inesperados e simplifica o raciocínio
sobre o comportamento do código. Ao modelar estados com Sealed Classes, você cria estruturas organizadas e encapsuladas que representam
possíveis cenários, garantindo que a manipulação desses estados seja previsível e sem alterar os dados originais.

```kotlin
sealed interface EstadoPedido
object Pendente : EstadoPedido
object Preparando : EstadoPedido
object Concluido : EstadoPedido

data class Pedido(
    val numero: Int,
    val estado: EstadoPedido,
) {
    fun atualizarEstado(novoEstado: EstadoPedido): Pedido =
        this.copy(estado = novoEstado) //número será mantido
}

fun main() {
    val pedidoPendente = Pedido(1, Pendente)
    val pedidoPreparando = Pedido(2, Preparando)

    val pedidoConcluido = pedidoPendente.atualizarEstado(Concluido)
    val pedidoEmPreparo = pedidoPendente.atualizarEstado(Pendente)

    println("Pedido #${pedidoConcluido.numero} está ${pedidoConcluido.estado}")
    println("Pedido #${pedidoEmPreparo.numero} está ${pedidoEmPreparo.estado}")
}
```

##### Sealed, Kotlin e a forte tipagem

A forte tipagem é uma característica fundamental em linguagens como Kotlin. Ela ajuda a evitar erros em tempo de compilação e a tornar o
código mais seguro e legível. As Sealed Classes e Sealed Interfaces se encaixam perfeitamente nesse contexto, pois fornecem uma maneira de
definir estruturas de dados de forma precisa e restrita. Isso evita que estados ou tipos inválidos sejam usados inadvertidamente, garantindo
uma manipulação segura dos dados.

```kotlin
sealed interface StatusDoPedido
data class EmAndamento(val tempoRestante: Int) : StatusDoPedido
data class Concluido(val horaEntrega: String) : StatusDoPedido

fun atualizarStatusDoPedido(status: PedidoStatus) {
    when (status) {
        is EmAndamento -> println("Pedido em andamento, tempo restante: ${pedido.tempoRestante} minutos")
        is Concluido -> println("Pedido concluído, entregue às ${pedido.horaEntrega}")
    }
}

fun main() {
    val pedidoEmAndamento = EmAndamento(tempoRestante = 15)
    val pedidoConcluido = Concluido(horaEntrega = "20:30")

    atualizarPedidoStatus(pedidoEmAndamento)
    atualizarPedidoStatus(pedidoConcluido)
}
```

##### Melhor suporte da IDE para tratar suas sealed

Uma coisa bem legal das Sealed Classes é que se alinha com ao padrão funcional `when` (ou correspondência de padrões). Essa abordagem
permite tratar de maneira exaustiva todos os casos possíveis, garantindo que todos os estados ou tipos sejam considerados.

Isso é especialmente útil quando se trabalha com funções puras, onde os dados são imutáveis e o tratamento de casos é crucial.

Sem contar que, ao adicionar um novo item (por exemplo, `Finalizado` utilizando o exemplo acima), o compilador irá alegar erro e forçar você
a tratar esse novo caso. Importante sempre manter cuidado com `else`, já que "engoliria" qualquer novo tipo de sua hierarquia selada.

```kotlin
sealed interface StatusDoPedido
data class Finalizado(val tempo: Int) : StatusDoPedido

fun atualizarStatusDoPedido(status: PedidoStatus) {
    when (status) {
        //compilador vai reclamar que "Finalizado" deve ser tratado
        is Finalizado -> println("Pedido finalizado ás ${status.tempo}")
    }
}
```

#### Vantagens

- **Hierarquia explícita**: Sealed classes fornecem uma maneira clara e explícita de definir uma hierarquia limitada de classes
  relacionadas. Isso ajuda a comunicar a estrutura da hierarquia aos desenvolvedores que trabalham no código.

- **Padrão de design**: Sealed classes seguem o padrão de design "State", permitindo representar diferentes estados ou variações de um tipo
  de forma organizada e mantendo a consistência em toda a hierarquia.

- **Exaustividade em when**: O uso de sealed classes em uma expressão when permite que o compilador faça verificações de exaustividade,
  garantindo
  que todos os casos possíveis sejam tratados. Isso ajuda a evitar erros em tempo de compilação.

- **Segurança em refatorações**: Sealed classes fornecem uma estrutura sólida para expansão futura sem quebrar o código existente. Adicionar
  novos
  casos é seguro, pois você precisa atualizar todas as partes do código que lidam com a expressão when.

#### Desvantagens

- **Restrição da hierarquia**: Sealed classes limitam a hierarquia a um conjunto fixo de subclasses. Isso pode ser restritivo em cenários
  onde a hierarquia precisa ser expandida dinamicamente.

- **Complexidade**: Hierarquias de classes muito complexas com muitos casos e comportamentos podem tornar o código difícil de entender e
  manter.

- **Acoplamento**: Sealed classes podem levar a um nível mais alto de acoplamento, pois os casos devem ser conhecidos e definidos na classe
  selada. Isso pode dificultar a criação de componentes independentes.

```kotlin
sealed class TipoMidia
class Imagem(val url: String) : TipoMidia()
class Video(val url: String) : TipoMidia()
// Difícil adicionar novos tipos de mídia sem modificar a classe selada
```

- **Uso impróprio**: Sealed classes podem ser usadas indevidamente, resultando em uma hierarquia desnecessariamente restrita ou criando mais
  complexidade do que o necessário.

```kotlin
sealed class EstadoCampo
object EstadoVazio : EstadoCampo() // Uso desnecessário de sealed class
```

- **Comportamentos complexos**: Casos de Sealed Classes que contêm lógica complexa ou múltiplos estados podem dificultar a compreensão do
  fluxo de
  controle do código.

#### Testabilidade

- **Cobertura de Casos**: Certifique-se de testar cada caso possível da sealed class. Cada subclasse deve ser testada para garantir que os
  comportamentos específicos sejam tratados corretamente.

```kotlin
sealed class Resultado
object Sucesso : Resultado()
class Erro(val mensagem: String) : Resultado()

@Test
fun testCoberturaCasos() {
    assertTrue(Sucesso is Resultado)
    assertTrue(Erro("Erro ocorreu") is Resultado)
}
```

- **Testes de Comportamentos**: Teste os métodos e comportamentos específicos de cada caso de sealed class. Isso ajuda a garantir que a
  lógica
  interna de cada caso esteja funcionando como esperado.

```kotlin
sealed class Cor
object Vermelho : Cor()
object Azul : Cor()

fun descreverCor(cor: Cor): String {
    return when (cor) {
        Vermelho -> "Cor vermelha"
        Azul -> "Cor azul"
    }
}

// Teste
@Test
fun testComportamentos() {
    assertEquals("Cor vermelha", descreverCor(Vermelho))
    assertEquals("Cor azul", descreverCor(Azul))
}
```

- **Testes de Manipulação**: Se você tiver métodos de manipulação que alteram o estado de uma sealed class, teste como eles alteram
  corretamente a
  instância.

```kotlin
sealed class Forma
object Quadrado : Forma()
object Circulo : Forma()

data class Coordenadas(val x: Int, val y: Int)

fun moverForma(forma: Forma, coordenadas: Coordenadas): Coordenadas {
    return when (forma) {
        Quadrado -> Coordenadas(coordenadas.x + 2, coordenadas.y + 2)
        Circulo -> Coordenadas(coordenadas.x - 1, coordenadas.y - 1)
    }
}

// Teste
@Test
fun testManipulacao() {
    val coordenadasIniciais = Coordenadas(3, 4)
    assertEquals(Coordenadas(5, 6), moverForma(Quadrado, coordenadasIniciais))
    assertEquals(Coordenadas(2, 3), moverForma(Circulo, coordenadasIniciais))
}
```

- **Verificação de Valores**: Verifique se os valores estão sendo mantidos corretamente quando você muda o estado de uma sealed class. Isso
  garante a integridade dos dados.

```kotlin
sealed class Moeda
object Real : Moeda()
object Dolar : Moeda()

data class Dinheiro(val valor: Double, val moeda: Moeda)

// Teste
@Test
fun testVerificacaoValores() {
    val dinheiro = Dinheiro(50.0, Real)
    val novoDinheiro = dinheiro.copy(moeda = Dolar)
    assertEquals(50.0, dinheiro.valor)
    assertEquals(Dolar, novoDinheiro.moeda)
}
```

- **Usar Factories**: Crie fábricas de testes para instâncias das sealed classes. Isso ajuda a centralizar a criação de instâncias e
  facilita a manutenção dos testes.

```kotlin
sealed class Animal
object Cachorro : Animal()
object Gato : Animal()

data class Pet(val nome: String, val animal: Animal)

fun petFake(
    nome: String = "Rex",
    animal: Animal = Cachorro,
) = Pet(nome, animal)

// Teste
@Test
fun testFactory() {
    val petCachorro = petFake()
    assertEquals("Rex", petCachorro.nome)
    assertEquals(Cachorro, petCachorro.animal)
}
```

- **Cenários de Erro**: Crie casos de teste para situações de erro, como tentar criar uma instância inválida. Verifique se exceções são
  lançadas conforme o esperado.

```kotlin
sealed class ResultadoOperacao
object Sucesso : ResultadoOperacao()
class Erro(val mensagem: String) : ResultadoOperacao()

fun executarOperacao(sucesso: Boolean): ResultadoOperacao =
    if (sucesso) Sucesso else Erro("Operação falhou")

// Teste
@Test
fun testCenariosErro() {
    assertTrue(executarOperacao(true) is Sucesso)
    assertTrue(executarOperacao(false) is Erro)
}
```

- **Testes de Desempenho**: Se a manipulação de instâncias sealed for um aspecto crítico do sistema, crie testes de desempenho para garantir
  que
  as operações sejam executadas eficientemente.

```kotlin
sealed class Trabalho
object Projeto : Trabalho()
object Tarefa : Trabalho()

fun executarTrabalho(trabalho: Trabalho): String {
    Thread.sleep(100) // Simula processamento
    return when (trabalho) {
        Projeto -> "Projeto concluído"
        Tarefa -> "Tarefa finalizada"
    }
}

// Teste de Desempenho
@Test(timeout = 500) // Limite de 500ms
fun testDesempenho() {
    assertEquals("Projeto concluído", executarTrabalho(Projeto))
}
```
