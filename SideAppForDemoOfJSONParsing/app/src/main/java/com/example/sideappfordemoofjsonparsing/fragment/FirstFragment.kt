package com.example.sideappfordemoofjsonparsing.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sideappfordemoofjsonparsing.R
import com.example.sideappfordemoofjsonparsing.data.Monster
import com.example.sideappfordemoofjsonparsing.ui.main.MonsterGridAdapter
import com.example.sideappfordemoofjsonparsing.ui.main.MonsterViewModel


class FirstFragment : Fragment(), MonsterGridAdapter.MonsterItemListener {

    private lateinit var viewModel: MonsterViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        //RecyclerView
        recyclerView=view.findViewById(R.id.monster_list_recycler_view)

        //ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(MonsterViewModel::class.java)
        viewModel.monsterData.observe(viewLifecycleOwner, Observer {
//            val monsterName = StringBuilder()
//            for (name in it) {
//                monsterName.append(name.monsterName).append("\n")
//            }
//            monster_name.text = monsterName
            recyclerView.adapter=MonsterGridAdapter(requireContext(),it,this)
        })

        return view
    }

    override fun onMonsterItemClickListener(monster: Monster) {
        Toast.makeText(requireContext(),monster.monsterName,Toast.LENGTH_SHORT).show()
    }


}
