package com.fara7.caffeine

import android.app.Application
import com.fara7.caffeine.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CaffeineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CaffeineApplication)
            modules(appModule)
        }
    }
}