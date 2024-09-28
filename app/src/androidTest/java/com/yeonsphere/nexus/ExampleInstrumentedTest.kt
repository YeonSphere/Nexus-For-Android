package com.yeonsphere.nexus

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.yeonsphere.nexus", appContext.packageName)
    }

    @Test
    fun testAppName() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val appName = appContext.getString(appContext.applicationInfo.labelRes)
        assertEquals("Nexus", appName)
    }

    @Test
    fun testAppVersion() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageInfo = appContext.packageManager.getPackageInfo(appContext.packageName, 0)
        assertNotNull(packageInfo.versionName)
        assertTrue(packageInfo.versionCode > 0)
    }
}