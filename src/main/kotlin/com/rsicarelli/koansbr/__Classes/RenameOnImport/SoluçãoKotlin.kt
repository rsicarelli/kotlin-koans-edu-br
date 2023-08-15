import java.util.Random as JRandom
import kotlin.random.Random as KRandom

fun useDifferentRandomClasses(): String {
    val kotlinRandom: Int = KRandom.nextInt(until = 2)
    val javaRandom: Int = JRandom().nextInt(/* bound = */ 2)

    return "Kotlin random: $kotlinRandom, Java random: $javaRandom."
}
