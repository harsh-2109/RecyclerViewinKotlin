package com.example.kotlindata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddata.utilities.FileHelper

class MainViewModel(application: Application) : AndroidViewModel(application) {
    init {
        val text:String= FileHelper.getTextFromAssets(application, "monster_data.json")
//        val text:String= FileHelper.getTextFromResources(application, R.raw.monster_data)
//        Log.i("Monster_LOG", text.toString())
        Log.i("Monster_LOG", text)
    }
}