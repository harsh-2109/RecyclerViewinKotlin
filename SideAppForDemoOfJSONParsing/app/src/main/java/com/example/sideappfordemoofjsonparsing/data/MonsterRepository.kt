package com.example.sideappfordemoofjsonparsing.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.sideappfordemoofjsonparsing.LOG_VAL
import com.example.sideappfordemoofjsonparsing.WEB_SERVICE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MonsterRepository(private val application: Application) {

    val monsterData = MutableLiveData<List<Monster>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }
    }

    @WorkerThread
    private suspend fun callWebService() {
        if (networkAvailable()) {
            Log.i(LOG_VAL, "Calling Web Service")
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(MonsterService::class.java)
                val serviceData = service.getMonsterData().body() ?: emptyList()
            monsterData.postValue(serviceData)
        }
    }

    @Suppress("DEPRECATION")
    fun networkAvailable(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo?.isConnectedOrConnecting ?: false
    }
}