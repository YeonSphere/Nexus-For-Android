package com.yeonsphere.nexus.browser

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

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
    }

    fun loadUrl(url: String) {
        webView.loadUrl(url)
    }
}