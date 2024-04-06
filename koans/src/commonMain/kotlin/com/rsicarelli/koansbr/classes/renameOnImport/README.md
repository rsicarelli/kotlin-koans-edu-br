## 🔗 [Tarefa](https://play.kotlinlang.org/koans/Classes/Rename%20on%20import/Task.kt) 

Ao [importar](https://kotlinlang.org/docs/packages.html#imports) uma classe ou função, você pode especificar um nome diferente para ela adicionando como NewName após a diretiva de importação. Isso pode ser útil se você quiser usar duas classes ou funções com nomes semelhantes de bibliotecas diferentes.

Descomente o código e faça-o compilar. Renomeie `Random` do pacote Kotlin para `KRandom` e `Random` do pacote Java para `JRandom`.

## Introdução ao "rename imports" do Kotlin.
Constantemente durante o dia a dia do desenvolvimento, utilizamos diversas funções e classes que possuem o mesmo nome. 

Por exemplo, vamos supor que você precise utilizar o Random do pacote `kotlin.random` e, ao mesmo tempo, o `Random` do pacote `java.util`:
```kotlin
fun useDifferentRandomClasses(): String {
   val kotlinRandom = kotlin.random.Random.nextInt(2)
   val javaRandom = java.util.Random().nextInt(2)

   return "Kotlin: $kotlinRandom, Java: $javaRandom."
}
```

Aqui, você precisa fazer uma escolha: ou importar o `java.util` ou `kotlin.random`:
```kotlin
import kotlin.random.Random

fun useDifferentRandomClasses() {
    val kotlinRandom = Random.nextInt(2)
    val javaRandom= java.util.Random().nextInt(2)
}
```
ou...
```kotlin
import java.util.Random

fun useDifferentRandomClasses(): String {
    val kotlinRandom = kotlin.random.Random.nextInt(2)
    val javaRandom = Random().nextInt(/* bound = */ 2)
}
```
Ao tentar importar os 2, recebemos um erro na IDE:



---

## Índice de exercícios

1. [Classes de Dados (Data Classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/dataClasses/README.md
   )

2. [Tipagem inteligente (Smart casts)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/smartCasts/README.md
   )

3. [Classes seladas (Sealed classes)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/sealedClasses/README.md
   )

4. ➡️ ** [Renomear ao importar (Rename on import)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/renameOnImport/README.md
   ) **

5. [Funções de extensão (Extension functions)](
   https://github.com/rsicarelli/kotlin-koans-edu-br/blob/main/koans/src/commonMain/kotlin/com/rsicarelli/koansbr/classes/extensionFunctions/README.md
   )
