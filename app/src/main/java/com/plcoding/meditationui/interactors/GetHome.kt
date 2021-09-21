package com.plcoding.meditationui.interactors

import com.plcoding.meditationui.domain.data.DataState
import com.plcoding.meditationui.domain.model.Home
import com.plcoding.meditationui.domain.model.Music
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHome {

    val homeTitle = "Home"

    fun execute(
        isNetworkAvailable: Boolean
    ): Flow<DataState<Home>> = flow {
        try {

            emit(DataState.loading())
            delay(1000)



            // get home from cache TODO
            var home = Home(homeTitle)

            if(home != null){
                emit(DataState.success(home))
            }
            else {
                if (isNetworkAvailable) {
                    // get home from network TODO
                    val networkHome =  Music(homeTitle)

                    // insert into cache TODO

                }
                // get from cache TODO
                home = Home(homeTitle)

                // emit and finish
                if(home != null){
                    emit(DataState.success(home))
                }
                else{
                    throw Exception("Unable to get home from the cache.")
                }
            }



        } catch (e: Exception) {
            emit(DataState.error<Home>(e.message?: "Unknown Error"))
        }


    }
}
