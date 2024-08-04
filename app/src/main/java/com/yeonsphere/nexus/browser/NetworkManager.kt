package com.yeonsphere.nexus.browser

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request

class NetworkManager {
    private val client = OkHttpClient()

    fun fetchUrl(url: String): String? {
        Log.d("NetworkManager", "Fetching URL: $url")

        val request = Request.Builder()
            .url(url)
            .build()

        return client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                Log.e("NetworkManager", "Failed to fetch URL: $url")
                return null
            }
            response.body?.string()
        }
    }
}