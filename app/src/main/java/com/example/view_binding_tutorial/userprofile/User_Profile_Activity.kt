package com.example.view_binding_tutorial.userprofile

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.userprofile.tabpageAdapter.TabPageAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_user_profile.*
import android.widget.ImageView


class User_Profile_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpTabBar()
        val name = intent.getStringExtra("name")
        val gmail = getIntent().getStringExtra("gmail")
        val phone_number = getIntent().getStringExtra("phone_number")
        val person_img = getIntent().getIntExtra("person_img",R.drawable.person_icon_fr)


        var person_name = findViewById<TextView>(R.id.user_profile_person_name)
        var person_gmail = findViewById<TextView>(R.id.user_profile_person_gmail)
        var person_phone_number = findViewById<TextView>(R.id.user_profile_phone_number)
        val person_photo = findViewById<ImageView>(R.id.user_profile_person_img)
        person_name.text = name
        person_gmail.text = gmail
        person_phone_number.text = phone_number
        person_photo.imageAlpha.and(person_img)

    }

    private fun setUpTabBar() {
        val adapter = TabPageAdapter(this,tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position:Int){
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}


