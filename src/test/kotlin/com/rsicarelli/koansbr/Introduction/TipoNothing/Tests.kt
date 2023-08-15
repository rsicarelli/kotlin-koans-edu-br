import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test

class Test2 {

    fun testAge(age: Int) {
        val e: IllegalArgumentException? = try {
            checkAge(age)
            null
        } catch (e: IllegalArgumentException) {
            e
        }
        assertNotNull(
            actual = e,
            message = "Expected IllegalArgumentException for 'checkAge($age)'"
        )
    }

    @Test
    fun testNegative() = testAge(-10)

    @Test
    fun testLargeNumber() = testAge(200)
}
