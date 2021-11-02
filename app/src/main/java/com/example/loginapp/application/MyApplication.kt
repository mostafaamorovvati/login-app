package com.example.loginapp.application

import android.app.Application
import com.example.loginapp.di.appModule
import com.example.loginapp.di.repositoryModule
import com.example.loginapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, viewModelModule, appModule))
        }
    }
}