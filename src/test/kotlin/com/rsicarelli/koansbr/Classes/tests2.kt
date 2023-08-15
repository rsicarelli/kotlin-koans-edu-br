import kotlin.test.DefaultAsserter.assertEquals

class TestExtensionFunctions() {

    @org.junit.jupiter.api.Test
    fun testIntExtension() {
        assertEquals("Rational number creation error: ", RationalNumber(4, 1), 4.r())
    }

    @org.junit.jupiter.api.Test
    fun testPairExtension() {
        assertEquals("Rational number creation error: ", RationalNumber(2, 3), Pair(2, 3).r())
    }
}
