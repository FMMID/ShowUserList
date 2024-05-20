package com.app.showlistapp

import android.app.Application
import com.app.showlistapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShowListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ShowListApp)
            modules(appModule)
        }
    }
}