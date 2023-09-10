import org.junit.Assert
import kotlin.test.Test
import koans.util.errorMessage

class TestGroupBy {
    @Test(timeout = 1000)
    fun testGroupCustomersByCity() {
        Assert.assertTrue(errorMessage("groupCustomersByCity"),
                groupedByCities == shop.groupCustomersByCity())
    }
}
