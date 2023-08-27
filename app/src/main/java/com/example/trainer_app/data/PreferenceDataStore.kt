package com.example.trainer_app.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.trainer_app.data.models.Token
import kotlinx.coroutines.flow.first

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class PreferenceDataStore(context:Context) {

    private val pref = context.dataStore
    companion object{
        val accessToken = stringPreferencesKey("ACCESS_TOKEN")
    }

    suspend fun saveToken(value: Token){
        pref.edit {
            it[accessToken] = value.accessToken
        }
    }

    suspend fun getToke(): String? {
        val values = pref.data.first()
        return values[accessToken]
    }

}