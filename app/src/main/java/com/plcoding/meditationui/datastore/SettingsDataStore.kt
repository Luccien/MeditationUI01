package com.plcoding.meditationui.datastore

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore

import com.plcoding.meditationui.MediatationApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SettingsDataStore
@Inject
constructor(app: MediatationApplication){

    private val datastore: DataStore<androidx.datastore.preferences.core.Preferences> = app.createDataStore(name = "settings")

    private val scope = CoroutineScope(Dispatchers.Main)

    init {
        observeDataStore()
    }

    val isDark = mutableStateOf(false)

    fun toggleTheme(){
        scope.launch {
            datastore.edit { preferences ->
                val current = preferences[DARK_THEME_KEY]?: false
                preferences[DARK_THEME_KEY] = !current
            }
        }
    }

    private fun observeDataStore(){
        datastore.data.onEach { preferences ->
            preferences[DARK_THEME_KEY]?.let { isDarkTheme ->
                isDark.value = isDarkTheme
            }
        }.launchIn(scope)
    }

    companion object{
        private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme_key")
    }
}