import org.junit.Assert
import kotlin.test.Test

class TestExtensionFunctionLiterals {
    @Test(timeout = 1000)
    fun testIsOddAndIsEven() {
        Assert.assertEquals("Wrong results for 'isOdd' and 'isEven' calls:\n",
                listOf(false, true, true), task())

    }
}
