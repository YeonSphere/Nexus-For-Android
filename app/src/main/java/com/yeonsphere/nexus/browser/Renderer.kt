package com.yeonsphere.nexus.browser

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient

class Renderer(private val webView: WebView) {

    init {
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Log.d("Renderer", "Page started loading: $url")
                // You can add UI updates here, like showing a progress bar
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                Log.d("Renderer", "Page finished loading: $url")
                // You can add UI updates here, like hiding the progress bar
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                Log.e("Renderer", "Error loading page: ${error?.description}")
                // Handle error, e.g., show an error message to the user
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                // Update progress bar or any other UI element
                Log.d("Renderer", "Loading progress: $newProgress%")
            }
        }

        // Enable JavaScript
        webView.settings.javaScriptEnabled = true

        // Enable DOM storage
        webView.settings.domStorageEnabled = true

        // Enable zooming
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
    }

    fun loadUrl(url: String) {
        webView.loadUrl(url)
    }

    fun goBack() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
    }

    fun goForward() {
        if (webView.canGoForward()) {
            webView.goForward()
        }
    }

    fun reload() {
        webView.reload()
    }
}