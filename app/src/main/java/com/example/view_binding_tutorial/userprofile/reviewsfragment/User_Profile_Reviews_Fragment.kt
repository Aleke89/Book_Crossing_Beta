package com.example.view_binding_tutorial.userprofile.reviewsfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.FragmentUserProfileReadedBinding
import com.example.view_binding_tutorial.databinding.FragmentUserProfileReviewsBinding
import com.example.view_binding_tutorial.databinding.ReviewsItemLayoutBinding
import com.example.view_binding_tutorial.userprofile.readedfragment.ReadedItem
import com.example.view_binding_tutorial.userprofile.readedfragment.User_Profile_Readed_Fragment_ItemAdapter

class User_Profile_Reviews_Fragment : Fragment(R.layout.fragment_user__profile__reviews_) , RecyclerViewInterface {
    private lateinit var binding: FragmentUserProfileReviewsBinding
    private val reviewsItemList:MutableList<ReviewsItem> = mutableListOf()
    private lateinit var reviewsItemAdapter: User_Profile_Reviews_Fragment_ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserProfileReviewsBinding.bind(view)


        val item1 = ReviewsItem("New York","New Paris",R.drawable.book_png)
        val item2 = ReviewsItem("New Qazaqstan","New Maldivy",R.drawable.book_png)

        reviewsItemList.add(item1)
        reviewsItemList.add(item2)
        reviewsItemAdapter = User_Profile_Reviews_Fragment_ItemAdapter(requireContext(),reviewsItemList,this)
        binding.bookItemRV.adapter = reviewsItemAdapter
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