package com.example.view_binding_tutorial.book_homepage.already_readed

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.FragmentAlreadyReadedFramgentBinding
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import com.example.view_binding_tutorial.userprofile.readedfragment.ReadedItem


class Already_Readed_Framgent : Fragment(R.layout.fragment_already__readed__framgent),RecyclerViewInterface {
    private lateinit var binding:FragmentAlreadyReadedFramgentBinding
    private val readedItemList:MutableList<Already_Readed_Item> = mutableListOf()
    private lateinit var readedItemAdapter: Already_Readed_ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlreadyReadedFramgentBinding.bind(view)

        val item1 = Already_Readed_Item("Vasya","Mathematics","11110546",R.drawable.person_icon_fr)
        val item2 = Already_Readed_Item("Madi","Dombyra","00000155",R.drawable.person_icon_fr)

        readedItemList.add(item1)
        readedItemList.add(item2)
        readedItemAdapter = Already_Readed_ItemAdapter(requireContext(),readedItemList,this)
        binding.bookItemRV.adapter = readedItemAdapter
        binding.bookItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.bookItemRV.setHasFixedSize(true)
    }
    override fun onItemClick(position: Int) {

    }

    override fun onItemClickBook(position: Int) {
        val intent = Intent(context, User_Profile_Activity::class.java)
        startActivity(intent)
    }


}