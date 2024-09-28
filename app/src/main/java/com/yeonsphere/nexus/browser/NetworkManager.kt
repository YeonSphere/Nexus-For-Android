package com.yeonsphere.nexus.browser

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class NetworkManager {
    private val client = OkHttpClient()

    suspend fun fetchUrl(url: String): String? = withContext(Dispatchers.IO) {
        Log.d("NetworkManager", "Fetching URL: $url")

        val request = Request.Builder()
            .url(url)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    Log.e("NetworkManager", "Failed to fetch URL: $url. Response code: ${response.code}")
                    null
                } else {
                    response.body?.string()
                }
            }
        } catch (e: IOException) {
            Log.e("NetworkManager", "Error fetching URL: $url", e)
            null
        }
    }
}