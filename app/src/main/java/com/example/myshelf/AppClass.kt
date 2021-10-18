package com.example.myshelf

import android.app.Application
import android.content.Context

/**
 *
 * @author enesdurmus
 */

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }
    companion object {
        var context: Context? = null
            internal set
    }
}