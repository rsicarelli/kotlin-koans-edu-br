import kotlin.test.DefaultAsserter.assertEquals

class TestSmartCasts {

    @org.junit.jupiter.api.Test
    fun testNum() {
        assertEquals("'eval' on Num(2) works incorrectly\n", 2, eval(Num(2)))
    }

    @org.junit.jupiter.api.Test
    fun testSum() {
        assertEquals("'eval' on Sum(Num(2), Num(1)) works incorrectly\n", 3, eval(Sum(Num(2), Num(1))))
    }

    @org.junit.jupiter.api.Test
    fun testRecursion() {
        assertEquals("'eval' on Sum(Sum(Num(1), Num(2)), Num(3)) works incorrectly\n", 6, eval(Sum(Sum(Num(1), Num(2)), Num(3))))
    }
}
