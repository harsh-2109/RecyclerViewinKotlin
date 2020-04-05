package com.example.sideappfordemoofjsonparsing.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sideappfordemoofjsonparsing.data.MonsterRepo

class MonsterViewModel(application: Application) : AndroidViewModel(application) {
    private val dataRepo = MonsterRepo(application)
    val monsterData = dataRepo.monsterData
}