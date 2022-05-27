package com.example.view_binding_tutorial.book_homepage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.view_binding_tutorial.book_homepage.already_readed.Already_Readed_Framgent
import com.example.view_binding_tutorial.book_homepage.description.Description_Fragment
import com.example.view_binding_tutorial.book_homepage.reading_user.Reading_User_Fragment
import com.example.view_binding_tutorial.book_homepage.reviews.Reviews_Fragment_bhp

class TabPageAdapterBook(activity: Book_home_page_Activity, private val tabCount:Int):FragmentStateAdapter(activity)
{

    override fun getItemCount(): Int= tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0-> Description_Fragment()
            1-> Reading_User_Fragment()
            2-> Already_Readed_Framgent()
            3-> Reviews_Fragment_bhp()
            else-> Description_Fragment()
        }
    }

}