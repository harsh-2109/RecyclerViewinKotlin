package com.example.sideappfordemoofjsonparsing.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sideappfordemoofjsonparsing.data.Monster
import com.example.sideappfordemoofjsonparsing.data.MonsterRepository

class MonsterViewModel(application: Application) : AndroidViewModel(application) {

    val selecetdMonster = MutableLiveData<Monster>()

    val dataRepo = MonsterRepository(application)
    val monsterData = dataRepo.monsterData
}