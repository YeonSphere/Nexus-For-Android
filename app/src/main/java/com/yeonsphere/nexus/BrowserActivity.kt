package com.yeonsphere.nexus

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.yeonsphere.nexus.browser.Renderer
import com.yeonsphere.nexus.browser.TabManager

class BrowserActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var tabManager: TabManager
    private lateinit var renderer: Renderer
    private lateinit var addressBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        initializeViews()
        setupTabManager()
        setupRenderer()
        setupAddressBar()
    }

    private fun initializeViews() {
        webView = findViewById(R.id.webview)
        addressBar = findViewById(R.id.address_bar)
    }

    private fun setupTabManager() {
        tabManager = TabManager()
    }

    private fun setupRenderer() {
        renderer = Renderer(webView)
    }

    private fun setupAddressBar() {
        addressBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                loadUrl(addressBar.text.toString())
                true
            } else {
                false
            }
        }
    }

    private fun loadUrl(url: String) {
        renderer.loadUrl(url)
        Log.d("BrowserActivity", "Loading URL: $url")
    }
}