package com.example.view_binding_tutorial.userprofile.recommendfragment

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
import com.example.view_binding_tutorial.databinding.FragmentUserProfileRecommendBinding
import com.example.view_binding_tutorial.userprofile.readedfragment.ReadedItem



class User_Profile_Recommend_Fragment : Fragment(R.layout.fragment_user__profile__recommend_),
    RecyclerViewInterface {
    private lateinit var binding: FragmentUserProfileRecommendBinding
    private val bookItemList: MutableList<RecommendedItem> = mutableListOf()
    private lateinit var bookItemAdapter: User_Profile_Recommended_Fragment_ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserProfileRecommendBinding.bind(view)

        val bookitem1 = RecommendedItem("Platon","Apology",R.drawable.book_png)
        val bookitem2 = RecommendedItem("Aleke","BikerSot",R.drawable.book_png)
        bookItemList.add(bookitem1)
        bookItemList.add(bookitem2)
        bookItemAdapter = User_Profile_Recommended_Fragment_ItemAdapter(requireContext(), bookItemList, this)
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