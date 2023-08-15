import kotlin.test.assertSame
import org.junit.jupiter.api.Test

class TestStart {

    @Test
    fun testOk() {
        assertSame(
            expected = "OK",
            actual = start()
        )
    }
}
