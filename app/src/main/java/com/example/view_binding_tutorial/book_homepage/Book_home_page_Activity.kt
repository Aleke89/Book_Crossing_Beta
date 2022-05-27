package com.example.view_binding_tutorial.book_homepage

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.view_binding_tutorial.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.book_item_layout.*

class Book_home_page_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_book_home_page)
        setUpTabBar()
        val name = getIntent().getStringExtra("name")
        val author = getIntent().getStringExtra("author")
        val genr = getIntent().getStringExtra("genre")
        val amoun = getIntent().getStringExtra("amount")
        val ratin = getIntent().getFloatExtra("rating",0.0F)
        val bitmap = getIntent().getIntExtra("book_photo",R.drawable.book_png)


        val book_name = findViewById<TextView>(R.id.book_hp_name)
        val book_author = findViewById<TextView>(R.id.book_hp_Author)
        val genre = findViewById<TextView>(R.id.book_hp_genre_type)
        val amount = findViewById<TextView>(R.id.book_hp_amount_number)
        val rating = findViewById<RatingBar>(R.id.book_hp_rating_bar)
        val book_img = findViewById<ImageView>(R.id.book_hp_img)

        book_name.text = name
        book_author.text = author
        genre.text = genr
        amount.text = amoun
        rating.rating = ratin
        book_img.setImageResource(bitmap)
    }
    private fun setUpTabBar() {
        val adapter = TabPageAdapterBook(this,tabLayout.tabCount)
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