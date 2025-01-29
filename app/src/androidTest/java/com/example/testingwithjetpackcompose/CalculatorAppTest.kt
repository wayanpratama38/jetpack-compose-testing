package com.example.testingwithjetpackcompose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.testingwithjetpackcompose.ui.theme.TestingWithJetpackComposeTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppTest{
    @get:Rule
    val composeTestRule =  createComposeRule()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            TestingWithJetpackComposeTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct(){
        composeTestRule.onNodeWithText("Masukkan panjang").performTextInput("3")
        composeTestRule.onNodeWithText("Masukkan lebar").performTextInput("4")
        composeTestRule.onNodeWithText("Hitung!").performClick()
        composeTestRule.onNodeWithText("Hasil : 12.0").assertExists()
    }
}