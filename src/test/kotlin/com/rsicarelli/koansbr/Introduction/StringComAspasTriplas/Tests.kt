import kotlin.test.assertSame
import org.junit.jupiter.api.Test

class Test3 {

    @Test
    fun testSolution() {
        assertSame(
            expected = """question = "life, the universe, and everything" answer = 42""",
            actual = tripleQuotedString,
            message = "The margin prefix shouldn't be present " +
                "in the resulting string",
        )
    }
}
