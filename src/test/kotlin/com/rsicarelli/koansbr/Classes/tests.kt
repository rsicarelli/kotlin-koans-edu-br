import kotlin.test.DefaultAsserter.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

class TestDataClasses {

    @org.junit.jupiter.api.Test
    fun testListOfPeople() {
        assertEquals(
            "The class Person is implemented incorrectly\n",
            "[Person(name=Alice, age=29), Person(name=Bob, age=31)]",
            getPeople().toString()
        )
    }

    @org.junit.jupiter.api.Test
    fun testComparePeople() {
        assertTrue(
            "'comparePeople' function should return true",
            comparePeople()
        )
    }
}
