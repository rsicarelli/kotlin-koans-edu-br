import kotlin.test.assertSame
import org.junit.jupiter.api.Test

class TestNamedArguments {

    @Test
    fun testJoinToString() {
        assertSame(
            "[yes, no, may be]",
            joinOptions(listOf("yes", "no", "may be"))
        )
    }
}
