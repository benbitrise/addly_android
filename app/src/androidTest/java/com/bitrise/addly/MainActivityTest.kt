package com.bitrise.addly

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.bitrise.addly.ui.theme.AddlyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            AddlyTheme {
                calculator()
            }
        }
    }

    @Test
    fun test_1_2_equals_3flaky() {
        val maybe3 = listOf(3, 4).random()
        check("1", "2", maybe3.toString())
    }

    @Test
    fun test_1_2_equals_3() {
        check("1", "2", "3")
    }

    @Test
    fun test_19_20_equals_39() {
        check("19", "20", "39")
    }


    @Test
    fun test_20_21_equals_41() {
        check("20", "21", "41")
    }

    fun check(
        operand1: String,
        operand2: String,
        sum: String
    ) {
        composeTestRule.onNodeWithTag("Operand 1")
            .performTextReplacement(operand1)
        composeTestRule.onNodeWithTag("Operand 2")
            .performTextReplacement(operand2)
        composeTestRule.onNodeWithTag("sum")
            .assertTextEquals(sum)
    }
}


