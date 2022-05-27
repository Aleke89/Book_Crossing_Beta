package com.example.view_binding_tutorial.userprofile.recommendfragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.UserProfileReadedItemLayoutBinding
import com.example.view_binding_tutorial.databinding.UserProfileRecommendedItemLayoutBinding
import com.example.view_binding_tutorial.userprofile.readedfragment.ReadedItem
import com.example.view_binding_tutorial.userprofile.readedfragment.User_Profile_Readed_Fragment
import java.io.ByteArrayOutputStream

class User_Profile_Recommended_Fragment_ItemAdapter(private val context: Context, private val recommendedItemList:MutableList<RecommendedItem>, private val itemclick: User_Profile_Recommend_Fragment):
    RecyclerView.Adapter<User_Profile_Recommended_Fragment_ItemAdapter.RecommendedItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedItemViewHolder {
        val binding = UserProfileRecommendedItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return RecommendedItemViewHolder(binding,itemclick)
    }

    override fun onBindViewHolder(holder: RecommendedItemViewHolder, position: Int) {
        val recommendedItem = recommendedItemList[position]
        holder.bind(recommendedItem)
        holder.binding.userProfileRecomended.setOnClickListener {
            val intent = Intent(context, Book_home_page_Activity::class.java)
            intent.putExtra("name",recommendedItem.book_name)
            intent.putExtra("author",recommendedItem.book_author)
            val bitmap = BitmapFactory.decodeResource(context.resources,recommendedItem.book_png) // your bitmap
            val bs = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs)
            intent.putExtra("book_photo", bs.toByteArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return recommendedItemList.size
    }
    class RecommendedItemViewHolder(UserProfileRecommendedItemLayoutBinding: UserProfileRecommendedItemLayoutBinding, ItemClick: User_Profile_Recommend_Fragment)
        : RecyclerView.ViewHolder(UserProfileRecommendedItemLayoutBinding.root) {
        val binding = UserProfileRecommendedItemLayoutBinding
        fun bind(recommendedItem: RecommendedItem) {
            binding.userProfileRecomendedBookName.text = recommendedItem.book_name
            binding.userProfileRecomendedBookAuthor.text = recommendedItem.book_author
        }

    }
}


