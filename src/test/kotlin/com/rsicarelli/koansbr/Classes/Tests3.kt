import kotlin.test.DefaultAsserter.assertTrue
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun testRandom() {
        val string = useDifferentRandomClasses()
        assertTrue(
            "The string should contain random numbers 0 or 1\n$string",
            setOf('0', '1').any { it in string })
    }
}
