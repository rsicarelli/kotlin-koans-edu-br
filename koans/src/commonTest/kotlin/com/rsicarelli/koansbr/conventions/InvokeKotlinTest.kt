
/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

import com.rsicarelli.koansbr.conventions.invoke.Invokable
import com.rsicarelli.koansbr.conventions.invoke.invokeTwice
import org.junit.Assert
import org.junit.Test

class InvokeKotlinTest {
    @Test(timeout = 1000)
    fun testInvokeTwice() = testInvokable(2, ::invokeTwice)

    private fun testInvokable(numberOfInvocations: Int, invokeSeveralTimes: (Invokable) -> Invokable) {
        val invokable = Invokable()
        val message = "The number of invocations is incorrect:\n"
        Assert.assertEquals(message, numberOfInvocations, invokeSeveralTimes(invokable).numberOfInvocations)
    }

    @Test(timeout = 1000)
    fun testNumberOfInvocations() {
        testInvokable(1) { it() }
        testInvokable(5) { it()()()()() }
        testInvokable(0) { it }
    }
}
