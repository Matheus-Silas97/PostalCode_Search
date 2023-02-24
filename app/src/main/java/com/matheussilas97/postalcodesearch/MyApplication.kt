package com.matheussilas97.postalcodesearch

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.matheussilas97.postalcodesearch.di.dataModule
import com.matheussilas97.postalcodesearch.di.domainModule
import com.matheussilas97.postalcodesearch.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

val mainModules = listOf(presentationModule, domainModule, dataModule)

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MyApplication.instance = applicationContext
        init()
    }

    private fun init() {
        initKoin()
    }


    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(mainModules)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Context? = null
            private set
    }
}



