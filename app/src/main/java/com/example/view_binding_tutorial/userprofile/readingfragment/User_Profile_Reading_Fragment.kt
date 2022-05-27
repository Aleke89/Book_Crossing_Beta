package com.example.view_binding_tutorial.userprofile.readingfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.FragmentReadingUserBinding
import com.example.view_binding_tutorial.databinding.FragmentUserProfileReadingBinding
import com.example.view_binding_tutorial.databinding.ReviewsItemLayoutBinding

class User_Profile_Reading_Fragment : Fragment(R.layout.fragment_user__profile__reading_) {
    private lateinit var binding: FragmentUserProfileReadingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserProfileReadingBinding.bind(view)
        binding.userProfileReading.setOnClickListener {
            intent()
        }
    }

    private fun intent() {
        val intent = Intent(context,Book_home_page_Activity::class.java)
        startActivity(intent)
    }


}