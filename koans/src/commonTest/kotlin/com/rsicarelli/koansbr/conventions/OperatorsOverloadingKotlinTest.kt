/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2023 Rodrigo Sicarelli
 */

import com.rsicarelli.koansbr.conventions.operatorsoverloading.MyDate
import com.rsicarelli.koansbr.conventions.operatorsoverloading.task1
import com.rsicarelli.koansbr.conventions.operatorsoverloading.task2
import org.junit.Assert
import org.junit.Test
import sun.security.krb5.KrbException.errorMessage

class OperatorsOverloadingKotlinTest {

    @Test(timeout = 1000)
    fun testAddOneTimeInterval() {
        Assert.assertEquals(
            errorMessage("com.rsicarelli.koansbr.conventions.operatorsoverloading.src.task1"),
            MyDate(2015, 5, 8),
            task1(MyDate(2014, 5, 1))
        )
    }

    @Test(timeout = 1000)
    fun testOneMonth() {
        Assert.assertEquals(
            errorMessage("com.rsicarelli.koansbr.conventions.operatorsoverloading.src.task2"),
            MyDate(2016, 0, 27),
            task2(MyDate(2014, 0, 1))
        )
    }

    @Test(timeout = 1000)
    fun testMonthChange() {
        Assert.assertEquals(
            errorMessage("com.rsicarelli.koansbr.conventions.operatorsoverloading.src.task2"),
            MyDate(2016, 1, 20),
            task2(MyDate(2014, 0, 25))
        )
    }
}
