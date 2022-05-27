package com.example.view_binding_tutorial.book_homepage.already_readed

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.book_homepage.already_readed.Already_Readed_ItemAdapter.AlreadyReadedItemViewHolder
import com.example.view_binding_tutorial.databinding.FragmentAlreadyReadedItemLayoutBinding
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import java.io.ByteArrayOutputStream

class Already_Readed_ItemAdapter(private val context: Context, private val readedItemList:MutableList<Already_Readed_Item>,private val itemClick:Already_Readed_Framgent):
RecyclerView.Adapter<AlreadyReadedItemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlreadyReadedItemViewHolder {
        val binding = FragmentAlreadyReadedItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return AlreadyReadedItemViewHolder(binding,itemClick)
    }

    override fun onBindViewHolder(holder: AlreadyReadedItemViewHolder, position: Int) {
        val readedItem = readedItemList[position]
        holder.bind(readedItem)
        holder.binding.personBackground.setOnClickListener {
            val intent = Intent(context,User_Profile_Activity::class.java)
            intent.putExtra("name", readedItem.person_name)
            intent.putExtra("phone_number", readedItem.person_number)
            val bitmap = BitmapFactory.decodeResource(context.resources,readedItem.person_img)
            val bs = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,bs)
            intent.putExtra("person_img",bs.toByteArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return readedItemList.size
    }
    class AlreadyReadedItemViewHolder(AlreadyReadedItemLayoutBinding:FragmentAlreadyReadedItemLayoutBinding,ItemClick:Already_Readed_Framgent):
    RecyclerView.ViewHolder(AlreadyReadedItemLayoutBinding.root){
        val binding = AlreadyReadedItemLayoutBinding
        init {
            itemView.setOnClickListener{
                ItemClick.onItemClickBook(adapterPosition)
            }
        }
        fun bind(readedItem: Already_Readed_Item) {
            binding.personName.text = readedItem.person_name
            binding.personGroupName.text = readedItem.person_group_name
            binding.personPhoneNumber.text = readedItem.person_number
        }

    }
}
