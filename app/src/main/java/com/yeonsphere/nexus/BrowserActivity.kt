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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        webView = findViewById(R.id.webview)
        val addressBar: EditText = findViewById(R.id.address_bar)

        tabManager = TabManager()
        renderer = Renderer(webView)

        addressBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                val url = addressBar.text.toString()
                renderer.loadUrl(url)
                Log.d("BrowserActivity", "Loading URL: $url")
                true
            } else {
                false
            }
        }
    }
}