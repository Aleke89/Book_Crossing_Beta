package com.example.view_binding_tutorial.book_homepage.reviews

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.book_homepage.already_readed.Already_Readed_Item
import com.example.view_binding_tutorial.book_homepage.already_readed.Already_Readed_ItemAdapter
import com.example.view_binding_tutorial.databinding.FragmentAlreadyReadedFramgentBinding
import com.example.view_binding_tutorial.databinding.FragmentReviewsBhpBinding
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity


class Reviews_Fragment_bhp : Fragment(R.layout.fragment_reviews__bhp),RecyclerViewInterface {
    private lateinit var binding: FragmentReviewsBhpBinding
    private val readedItemList:MutableList<ReviewsItem> = mutableListOf()
    private lateinit var readedItemAdapter: ReviewsItemAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReviewsBhpBinding.bind(view)

        val item1 = ReviewsItem("Vasya",2.8F,"11110546",R.drawable.person_icon_fr)
        val item2 = ReviewsItem("Madi",1.5F,"00000155",R.drawable.person_icon_fr)

        readedItemList.add(item1)
        readedItemList.add(item2)
        readedItemAdapter = ReviewsItemAdapter(requireContext(),readedItemList,this)
        binding.userratingItemRV.adapter = readedItemAdapter
        binding.userratingItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.userratingItemRV.setHasFixedSize(true)
    }
    override fun onItemClick(position: Int) {

    }

    override fun onItemClickBook(position: Int) {
        val intent = Intent(context, User_Profile_Activity::class.java)
        startActivity(intent)
    }


}