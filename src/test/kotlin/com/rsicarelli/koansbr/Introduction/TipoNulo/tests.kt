import kotlin.test.assertSame
import org.junit.jupiter.api.Test

class TestNullableTypes {

    fun testSendMessageToClient(
        client: Client?,
        message: String?,
        expectedEmail: String? = null,
        shouldBeInvoked: Boolean = false,
    ) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                assertSame(
                    expected = expectedMessage,
                    actual = message,
                    message = "The message is not as expected:",
                )
                assertSame(
                    expected = expectedEmail,
                    actual = email,
                    message = "The email is not as expected:",
                )
            }
        })
        assertSame(
            expected = shouldBeInvoked,
            actual = invoked,
            message = "The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
        )
    }

    @Test
    fun everythingIsOk() {
        testSendMessageToClient(
            Client(PersonalInfo("bob@gmail.com")),
            "Hi Bob! We have an awesome proposition for you...",
            "bob@gmail.com",
            true
        )
    }

    @Test
    fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test
    fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
}
