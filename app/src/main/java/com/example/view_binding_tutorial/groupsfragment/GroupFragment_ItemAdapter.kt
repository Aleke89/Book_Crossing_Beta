package com.example.view_binding_tutorial.groupsfragment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.databinding.GroupItemLayoutBinding
import com.example.view_binding_tutorial.groupsfragment.group_users.Group_Users


class GroupFragment_ItemAdapter(private val context: Context, private val groupItemList: MutableList<GroupItem>) :
    RecyclerView.Adapter<GroupFragment_ItemAdapter.GroupItemViewHOlder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupItemViewHOlder {
        val binding = GroupItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

        return GroupItemViewHOlder(binding)
    }

    override fun onBindViewHolder(
        holder: GroupItemViewHOlder,
        position: Int
    ) {
        val groupItem = groupItemList[position]
        holder.bind(groupItem)

        holder.binding.cardView.setOnClickListener {
            val intent = Intent(context,Group_Users::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return groupItemList.size
    }

    class GroupItemViewHOlder(groupItemLayoutBinding: GroupItemLayoutBinding) :
        RecyclerView.ViewHolder(groupItemLayoutBinding.root) {

        val binding = groupItemLayoutBinding

        fun bind(groupItem: GroupItem) {
            binding.groupName.text = groupItem.group_name
            binding.groupPeoplenum.text = "${groupItem.people_number}"
            binding.groupStars.text = "${groupItem.stars}"
            binding.groupBackground.setImageResource(groupItem.group_background)


        }

    }
}