import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test

class TestLambdas() {

    @Test
    fun contains() {
        assertTrue(
            actual = containsEven(
                collection = listOf(1, 2, 3, 126, 555)
            ),
            message = "The result should be true if the collection contains an even number"
        )
    }

    @Test
    fun notContains() {
        assertFalse(
            actual = containsEven(
                collection = listOf(43, 33)
            ),
            message = "The result should be false if the collection doesn't contain an even number"
        )
    }
}
