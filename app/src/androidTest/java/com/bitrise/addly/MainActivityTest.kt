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
    fun test_1_2_equals_3() {
        check("1", "2", "3")
    }

    @Test
    fun test_2_3_equals_5() {
        check("2", "3", "5")
    }

    @Test
    fun test_3_4_equals_7() {
        check("3", "4", "7")
    }

    @Test
    fun test_4_5_equals_9() {
        check("4", "5", "9")
    }

    @Test
    fun test_5_6_equals_11() {
        check("5", "6", "11")
    }

    @Test
    fun test_6_7_equals_13() {
        check("6", "7", "13")
    }

    @Test
    fun test_7_8_equals_15() {
        check("7", "8", "15")
    }

    @Test
    fun test_8_9_equals_17() {
        check("8", "9", "17")
    }

    @Test
    fun test_9_10_equals_19() {
        check("9", "10", "19")
    }

    @Test
    fun test_10_11_equals_21() {
        check("10", "11", "21")
    }

    @Test
    fun test_11_12_equals_23() {
        check("11", "12", "23")
    }


    @Test
    fun test_12_13_equals_25() {
        check("12", "13", "25")
    }


    @Test
    fun test_13_14_equals_27() {
        check("13", "14", "27")
    }


    @Test
    fun test_14_15_equals_29() {
        check("14", "15", "29")
    }


    @Test
    fun test_15_16_equals_31() {
        check("15", "16", "31")
    }


    @Test
    fun test_16_17_equals_33() {
        check("16", "17", "33")
    }


    @Test
    fun test_17_18_equals_35() {
        check("17", "18", "35")
    }


    @Test
    fun test_18_19_equals_37() {
        check("18", "19", "37")
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
            .performTextInput(operand1)
        composeTestRule.onNodeWithTag("Operand 2")
            .performTextInput(operand2)
        composeTestRule.onNodeWithTag("sum")
            .assertTextEquals(sum)
    }
}


