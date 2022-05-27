package com.example.view_binding_tutorial.userprofile.tabpageAdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import com.example.view_binding_tutorial.userprofile.readingfragment.User_Profile_Reading_Fragment
import com.example.view_binding_tutorial.userprofile.readedfragment.User_Profile_Readed_Fragment
import com.example.view_binding_tutorial.userprofile.recommendfragment.User_Profile_Recommend_Fragment
import com.example.view_binding_tutorial.userprofile.reviewsfragment.User_Profile_Reviews_Fragment


class TabPageAdapter(activity: User_Profile_Activity, private val tabCount:Int):FragmentStateAdapter(activity)
     {

    override fun getItemCount(): Int= tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0-> User_Profile_Reading_Fragment()
            1-> User_Profile_Readed_Fragment()
            2-> User_Profile_Reviews_Fragment()
            3-> User_Profile_Recommend_Fragment()
            else-> User_Profile_Reading_Fragment()
        }
    }

}