package com.example.view_binding_tutorial.book_homepage.reading_user

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.databinding.FragmentReadingUserBinding
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import java.io.ByteArrayOutputStream


class Reading_User_Fragment : Fragment(R.layout.fragment_reading__user_) {
    private lateinit var binding : FragmentReadingUserBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReadingUserBinding.bind(view)
        binding.personBackgroundd.setOnClickListener {
            val intent = Intent(context,User_Profile_Activity::class.java)
            intent.putExtra("name",binding.personName.text)
            val photo = binding.personImg.imageAlpha
            intent.putExtra("person_img",photo)
            intent.putExtra("phone_number",binding.personPhoneNumber.text)
            context?.startActivity(intent)
        }
    }
}