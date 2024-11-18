package com.dck.composemultimodulenavigation

import android.app.Application
import com.dck.core.di.coreModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(coreModule)
        }
    }
}