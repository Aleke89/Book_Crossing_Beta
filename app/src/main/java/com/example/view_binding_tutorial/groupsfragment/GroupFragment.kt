package com.example.view_binding_tutorial.bookfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.databinding.FragmentGroupBinding
import com.example.view_binding_tutorial.groupsfragment.GroupFragment_ItemAdapter
import com.example.view_binding_tutorial.groupsfragment.GroupItem
import com.example.view_binding_tutorial.userratingfragment.UserRatingItem
import java.util.*
import kotlin.collections.ArrayList


class GroupFragment:Fragment(R.layout.fragment_group){
    private lateinit var binding: FragmentGroupBinding
    private val groupItemList:MutableList<GroupItem> = mutableListOf()
    private lateinit var groupItemAdapter: GroupFragment_ItemAdapter
    private var examplelist:ArrayList<GroupItem> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGroupBinding.bind(view)

        val groupItem1 = GroupItem("Technolab",4,5,R.drawable.gradient1)
        val groupItem2 = GroupItem("2E",4,1,R.drawable.gradient2)
        groupItemList.add(groupItem1)
        groupItemList.add(groupItem2)

        groupItemAdapter = GroupFragment_ItemAdapter(requireContext(),examplelist)
        binding.groupItemRV.adapter = groupItemAdapter
        binding.groupItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.groupItemRV.setHasFixedSize(true)

        examplelist.addAll(groupItemList)

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                examplelist.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    groupItemList.forEach(){
                        if(it.group_name.lowercase(Locale.getDefault()).contains(searchText)){
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