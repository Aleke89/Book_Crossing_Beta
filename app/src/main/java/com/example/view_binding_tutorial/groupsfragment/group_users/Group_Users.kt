package com.example.view_binding_tutorial.groupsfragment.group_users

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.databinding.ActivityGroupUsersBinding
import com.example.view_binding_tutorial.groupsfragment.GroupFragment_ItemAdapter
import com.example.view_binding_tutorial.groupsfragment.GroupItem
import java.util.*
import kotlin.collections.ArrayList

class Group_Users : AppCompatActivity(R.layout.activity_group_users) {
    private lateinit var binding: ActivityGroupUsersBinding
    private val groupItemList:MutableList<Group_Users_Item> = mutableListOf()
    private lateinit var groupItemAdapter: Group_Users_ItemAdapter
    private var examplelist:ArrayList<Group_Users_Item> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityGroupUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val groupItem1 = Group_Users_Item("Aleke","Math","87711593543",R.drawable.person_icon_fr)
        val groupItem2 = Group_Users_Item("Dias","Designer","12345678910",R.drawable.person_icon_fr)
        groupItemList.add(groupItem1)
        groupItemList.add(groupItem2)

        groupItemAdapter = Group_Users_ItemAdapter(this,examplelist)
        binding.groupItemRV.adapter = groupItemAdapter
        binding.groupItemRV.layoutManager = LinearLayoutManager(this)
        binding.groupItemRV.setHasFixedSize(true)

        examplelist.addAll(groupItemList)

        binding.search.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener,androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                examplelist.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    groupItemList.forEach(){
                        if(it.person_name.lowercase(Locale.getDefault()).contains(searchText)){
                            examplelist.add(it)
                        }
                    }
                    binding.groupItemRV.adapter!!.notifyDataSetChanged()
                }else{
                    examplelist.clear()
                    examplelist.addAll(groupItemList)
                    binding.groupItemRV.adapter?.notifyDataSetChanged()
                }
                return false
            }
        })
    }
}