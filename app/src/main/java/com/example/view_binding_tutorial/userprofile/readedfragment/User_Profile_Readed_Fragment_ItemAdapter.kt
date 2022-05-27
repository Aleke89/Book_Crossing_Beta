package com.example.view_binding_tutorial.userprofile.readedfragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.UserProfileReadedItemLayoutBinding
import java.io.ByteArrayOutputStream


class User_Profile_Readed_Fragment_ItemAdapter(private val context: Context,private val readedItemList:MutableList<ReadedItem>,private val itemclick: User_Profile_Readed_Fragment):RecyclerView.Adapter<User_Profile_Readed_Fragment_ItemAdapter.ReadedItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadedItemViewHolder {
        val binding = UserProfileReadedItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ReadedItemViewHolder(binding,itemclick)
    }

    override fun onBindViewHolder(holder: ReadedItemViewHolder, position: Int) {
        val readedItem = readedItemList[position]
        holder.bind(readedItem)
        holder.binding.userProfileReaded.setOnClickListener {
            val intent = Intent(context, Book_home_page_Activity::class.java)
            intent.putExtra("name",readedItem.book_name)
            intent.putExtra("author",readedItem.book_author)
            val bitmap = BitmapFactory.decodeResource(context.resources,readedItem.book_photo) // your bitmap
            val bs = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs)
            intent.putExtra("book_photo", bs.toByteArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return readedItemList.size
    }
    class ReadedItemViewHolder(UserProfileReadedItemLayoutBinding: UserProfileReadedItemLayoutBinding, ItemClick: User_Profile_Readed_Fragment)
            : RecyclerView.ViewHolder(UserProfileReadedItemLayoutBinding.root) {
         val binding = UserProfileReadedItemLayoutBinding
        init {
            itemView.setOnClickListener{
                ItemClick.onItemClickBook(adapterPosition)
            }
        }
        fun bind(readedItem: ReadedItem) {
            binding.userProfileReadedBookName.text = readedItem.book_name
            binding.userProfileReadedBookAuthor.text = readedItem.book_author
        }

    }

}


