package com.example.view_binding_tutorial.userprofile.readedfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.databinding.FragmentUserProfileReadedBinding

class User_Profile_Readed_Fragment : Fragment(R.layout.fragment_user__profile__readed_),
    RecyclerViewInterface {
    private lateinit var binding: FragmentUserProfileReadedBinding
    private val bookItemList: MutableList<ReadedItem> = mutableListOf()
    private lateinit var bookItemAdapter: User_Profile_Readed_Fragment_ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserProfileReadedBinding.bind(view)

        val bookitem1 = ReadedItem("Platon","Apology",R.drawable.book_png)
        bookItemList.add(bookitem1)
        bookItemAdapter = User_Profile_Readed_Fragment_ItemAdapter(requireContext(), bookItemList, this)
        binding.bookItemRV.adapter = bookItemAdapter
        binding.bookItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.bookItemRV.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {

    }

    override fun onItemClickBook(position: Int) {
        val intent = Intent(context, Book_home_page_Activity::class.java)
        startActivity(intent)
    }
}