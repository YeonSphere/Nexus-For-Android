package com.yeonsphere.nexus.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yeonsphere.nexus.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BrowserScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testUrlBarIsDisplayed() {
        composeTestRule.onNodeWithTag("urlBar").assertExists()
    }

    @Test
    fun testNavigationButtonsAreDisplayed() {
        composeTestRule.onNodeWithTag("backButton").assertExists()
        composeTestRule.onNodeWithTag("forwardButton").assertExists()
        composeTestRule.onNodeWithTag("refreshButton").assertExists()
    }

    @Test
    fun testUrlInputAndNavigation() {
        val testUrl = "https://www.example.com"
        
        // Type URL
        composeTestRule.onNodeWithTag("urlBar")
            .performTextInput(testUrl)
        
        // Press enter
        composeTestRule.onNodeWithTag("urlBar")
            .performKeyPress(androidx.compose.ui.input.key.Key.Enter)
        
        // Verify URL is loaded
        composeTestRule.onNodeWithTag("webView").assertExists()
    }

    @Test
    fun testTabManagement() {
        // Open new tab
        composeTestRule.onNodeWithTag("newTabButton").performClick()
        
        // Verify new tab is created
        composeTestRule.onNodeWithTag("tabCounter")
            .assertTextContains("2")
        
        // Close tab
        composeTestRule.onNodeWithTag("closeTabButton").performClick()
        
        // Verify tab is closed
        composeTestRule.onNodeWithTag("tabCounter")
            .assertTextContains("1")
    }

    @Test
    fun testBookmarkFunctionality() {
        // Add bookmark
        composeTestRule.onNodeWithTag("bookmarkButton").performClick()
        
        // Open bookmarks
        composeTestRule.onNodeWithTag("bookmarksMenu").performClick()
        
        // Verify bookmark exists
        composeTestRule.onNodeWithText("Example").assertExists()
    }
}
