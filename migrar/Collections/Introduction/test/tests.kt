import org.junit.Assert
import kotlin.test.Test
import koans.util.errorMessage

class TestIntroduction {
    @Test(timeout = 1000)
    fun testSetOfCustomers() {
        Assert.assertTrue(errorMessage("getSetOfCustomers"),
                shop.getSetOfCustomers() == customers.values.toSet())
    }
}
