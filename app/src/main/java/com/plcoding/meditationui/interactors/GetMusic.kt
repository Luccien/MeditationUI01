package com.plcoding.meditationui.interactors

import com.plcoding.meditationui.domain.data.DataState
import com.plcoding.meditationui.domain.model.Music
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMusic {

    fun execute(
        isNetworkAvailable: Boolean
    ): Flow<DataState<Music>> = flow {
        try {

            emit(DataState.loading())
            delay(1000)

            // get music from cache TODO
            var music = Music("testTitle2")

            if(music != null){
                emit(DataState.success(music))
            }
           else {
                if (isNetworkAvailable) {
                    // get music from network TODO
                    val networkRecipe =  Music("testTitle2")

                    // insert into cache TODO

                }
                // get from cache TODO
                music = Music("testTitle2")

                // emit and finish
                if(music != null){
                    emit(DataState.success(music))
                }
                else{
                    throw Exception("Unable to get music from the cache.")
                }
            }

        } catch (e: Exception) {
            emit(DataState.error<Music>(e.message?: "Unknown Error"))
        }


    }
}