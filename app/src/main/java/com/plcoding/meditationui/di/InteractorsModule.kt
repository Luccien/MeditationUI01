package com.plcoding.meditationui.di

import com.plcoding.meditationui.interactors.GetHome
import com.plcoding.meditationui.interactors.GetMusic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {


    @ViewModelScoped
    @Provides
    fun provideGetMusic( ): GetMusic {
        return GetMusic()
        }

    @ViewModelScoped
    @Provides
    fun provideGetHome( ): GetHome {
        return GetHome()
    }

}