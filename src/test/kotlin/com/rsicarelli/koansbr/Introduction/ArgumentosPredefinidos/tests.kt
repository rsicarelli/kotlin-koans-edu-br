import kotlin.test.assertSame
import org.junit.jupiter.api.Test

class TestDefaultAndNamedParams() {

    @Test
    fun testDefaultAndNamedParams() {
        assertSame(
            expected = listOf("a42", "b1", "C42", "D2"),
            actual = useFoo(),
            message = "'useFoo()' returns wrong result\n",
        )
    }
}
