
package com.example.view_binding_tutorial.groupsfragment.group_users

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.databinding.FragmentGroupUsersItemLayoutBinding
import com.example.view_binding_tutorial.databinding.GroupItemLayoutBinding
import com.example.view_binding_tutorial.groupsfragment.GroupFragment_ItemAdapter
import com.example.view_binding_tutorial.groupsfragment.GroupItem
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity


class Group_Users_ItemAdapter(private val context: Context, private val groupItemList: MutableList<Group_Users_Item>):RecyclerView.Adapter<Group_Users_ItemAdapter.GroupUsersItemViewHolder>() {
    class GroupUsersItemViewHolder(groupUsersItemLayoutBinding: FragmentGroupUsersItemLayoutBinding):RecyclerView.ViewHolder(groupUsersItemLayoutBinding.root) {
        val binding = groupUsersItemLayoutBinding
        fun bind(groupItem: Group_Users_Item) {
            binding.personImg.setImageResource(groupItem.person_img)
            binding.personName.text = groupItem.person_name
            binding.personPhoneNumber.text = groupItem.person_number
            binding.personGroupName.text = groupItem.person_group
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupUsersItemViewHolder {
        val binding = FragmentGroupUsersItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

        return GroupUsersItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupUsersItemViewHolder, position: Int) {
        val groupItem = groupItemList[position]
        holder.bind(groupItem)

        holder.binding.personBackgroundd.setOnClickListener  {
            val intent = Intent(context,User_Profile_Activity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return groupItemList.size
    }

}