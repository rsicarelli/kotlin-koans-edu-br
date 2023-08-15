import com.rsicarelli.koansbr.classes.dataClasses.comparePeople
import com.rsicarelli.koansbr.classes.dataClasses.getPeople
import kotlin.test.DefaultAsserter.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

class TestDataClasses {

    @org.junit.jupiter.api.Test
    fun testListOfPeople() {
        assertEquals(
            "The class com.rsicarelli.koansbr.classes.dataClasses.Person is implemented incorrectly\n",
            "[com.rsicarelli.koansbr.classes.dataClasses.Person(name=Alice, age=29), com.rsicarelli.koansbr.classes.dataClasses.Person(name=Bob, age=31)]",
            getPeople().toString()
        )
    }

    @org.junit.jupiter.api.Test
    fun testComparePeople() {
        assertTrue(
            "'com.rsicarelli.koansbr.classes.dataClasses.comparePeople' function should return true",
            comparePeople()
        )
    }
}
