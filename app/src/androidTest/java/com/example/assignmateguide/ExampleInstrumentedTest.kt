package com.example.assignmateguide

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTypingAndScreenNavigation() {

        composeTestRule.setContent {
            MyApp()
        }

        composeTestRule.onNodeWithText("add/edit task").performClick()

        composeTestRule.onNode(hasTestTag("title_input")).performTextInput("Testing Input")

        composeTestRule.onNodeWithContentDescription("Save").performClick()

        composeTestRule.onNodeWithText("Diego Lozano").assertIsDisplayed()
    }
}