package com.plcoding.meditationui.interactors

import com.plcoding.meditationui.domain.model.Music
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMusic {

    fun execute(
        //isNetworkAvailable: Boolean // todo check for network
    ): Flow<Music> = flow {
        try {

            //delay(1000)
            delay(1000)

            emit(Music("testTitle"))
        } catch (e: Exception) {
            //emit(DataState.error<Music>(e.message?: "Unknown Error")) // todo DataState
        }


    }
}