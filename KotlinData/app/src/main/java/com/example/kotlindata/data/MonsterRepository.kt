package com.example.kotlindata.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlindata.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MonsterRepository(private val application: Application) {

    val monsterData = MutableLiveData<List<Monster>>()
    private val listType = Types.newParameterizedType(List::class.java, Monster::class.java)

    init {
        getMonsterData()
    }

    fun getMonsterData() {
        val text: String = FileHelper.getTextFromAssets(application, "monster_data.json")

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<List<Monster>> = moshi.adapter(listType)
        monsterData.value = adapter.fromJson(text) ?: emptyList()
    }
}