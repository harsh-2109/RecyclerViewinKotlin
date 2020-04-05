package com.example.sideappfordemoofjsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import com.example.sideappfordemoofjsonparsing.data.MonsterRepo
import com.example.sideappfordemoofjsonparsing.ui.main.MonsterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MonsterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MonsterViewModel::class.java)
        viewModel.monsterData.observe(this,)


    }
}
