package com.example.kotlindata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider
import com.example.kotlindata.data.Monster
import com.example.kotlindata.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monster=Monster("Harsh","Bla Bla Bla Bla Bla", "Yo yo yo", "My Description",30.20,2)

        Log.i("DataModel_File_Output", monster.toString())

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}