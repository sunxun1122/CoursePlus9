package com.example.core

import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    companion object {
        @JvmStatic
        @get:JvmName("currentApplication")
        lateinit var currentApplication: Context
            private set // 确保属性只读
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}