package com.example.sideappfordemoofjsonparsing.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.sideappfordemoofjsonparsing.WEB_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MonsterRepo(val application: Application) {

    val monsterData = MutableLiveData<List<Monster>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            callWebServices()
        }
    }

    @WorkerThread
    suspend fun callWebServices() {
        val retrofit = Retrofit.Builder()
            .baseUrl(WEB_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val services = retrofit.create(MonsterServices::class.java)
        val serviceData = services.getMonsterData().body() ?: emptyList()
        monsterData.postValue(serviceData)
    }

    @Suppress("DEPRECATION")
    fun networkAvailable(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo?.isConnectedOrConnecting ?: false
    }
}