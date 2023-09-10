import org.junit.Assert
import kotlin.test.Test
import koans.util.errorMessage

class TestPartition {
    @Test(timeout = 1000)
    fun testGetCustomersWhoHaveMoreUndeliveredOrdersThanDelivered() {
        Assert.assertTrue(errorMessage("getCustomersWithMoreUndeliveredOrders"),
                setOf(customers[reka]) == shop.getCustomersWithMoreUndeliveredOrders())
    }
}
