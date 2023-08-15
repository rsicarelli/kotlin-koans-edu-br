import kotlin.test.DefaultAsserter.assertTrue
import kotlin.test.assertFalse
import org.junit.jupiter.api.Test

class TestStringTemplates {

    @Test
    fun match() {
        assertTrue(
            actual = "11 MAR 1952".matches(getPattern().toRegex()),
            message = "The pattern should match ${"11 MAR 1952"}",
        )
    }

    @Test
    fun match1() {
        assertTrue(
            actual = "24 AUG 1957".matches(getPattern().toRegex()),
            message = "The pattern should match ${"24 AUG 1957"}",
        )
    }

    @Test
    fun doNotMatch() {
        assertFalse(
            actual = "24 RRR 1957".matches(getPattern().toRegex()),
            message = "The pattern shouldn't match ${"24 RRR 1957"}"
        )
    }
}
