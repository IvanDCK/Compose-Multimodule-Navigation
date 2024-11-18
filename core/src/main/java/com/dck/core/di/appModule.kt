package com.dck.core.di

import com.dck.module_b.presentation.model.Mobile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMobileObject(): Mobile {
        return Mobile("Samsung", 1000.0, "Black", 6.5)
    }
}