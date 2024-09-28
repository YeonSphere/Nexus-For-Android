package com.yeonsphere.nexus.browser

import android.util.Log

class TabManager {
    private val tabs = mutableListOf<Tab>()
    private var currentTabIndex = -1

    fun openNewTab(url: String) {
        val newTab = Tab(url)
        tabs.add(newTab)
        currentTabIndex = tabs.size - 1
        Log.d("TabManager", "Opened new tab with URL: $url")
    }

    fun closeTab(index: Int) {
        if (index in 0 until tabs.size) {
            tabs.removeAt(index)
            if (currentTabIndex >= tabs.size) {
                currentTabIndex = tabs.size - 1
            }
            Log.d("TabManager", "Closed tab at index: $index")
        }
    }

    fun switchTab(index: Int) {
        if (index in 0 until tabs.size) {
            currentTabIndex = index
            Log.d("TabManager", "Switched to tab at index: $index")
        }
    }

    fun getCurrentTab(): Tab? {
        return if (currentTabIndex != -1) tabs[currentTabIndex] else null
    }

    fun getTabCount(): Int {
        return tabs.size
    }
}

data class Tab(val url: String)