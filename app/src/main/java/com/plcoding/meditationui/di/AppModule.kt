package com.plcoding.meditationui.di

import android.content.Context
import com.plcoding.meditationui.presentation.MediatationApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMediatationApplication(@ApplicationContext app: Context): MediatationApplication {
        return app as MediatationApplication
    }

}