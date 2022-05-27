package com.example.view_binding_tutorial.userprofile.reviewsfragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.ReviewsItemLayoutBinding
import com.example.view_binding_tutorial.userprofile.reviewsfragment.User_Profile_Reviews_Fragment_ItemAdapter.*
import java.io.ByteArrayOutputStream

class User_Profile_Reviews_Fragment_ItemAdapter(private val context: Context, private val reviewsItemList:MutableList<ReviewsItem>,private val itemClick:User_Profile_Reviews_Fragment):
RecyclerView.Adapter<ReviewsItemViewHolder>() {
    class ReviewsItemViewHolder(UserProfileReviewsItemLayoutBinding:ReviewsItemLayoutBinding,ItemClick:User_Profile_Reviews_Fragment):
    RecyclerView.ViewHolder(UserProfileReviewsItemLayoutBinding.root){
        val binding = UserProfileReviewsItemLayoutBinding
        fun bind(reviewsItem:ReviewsItem){
            binding.userProfileReviewsBook.setImageResource(reviewsItem.book_png)
            binding.userProfileReviewsBookName.text = reviewsItem.book_name
            binding.userProfileReviewsBookAuthor.text = reviewsItem.book_author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsItemViewHolder {
        val binding = ReviewsItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ReviewsItemViewHolder(binding,itemClick)
    }

    override fun onBindViewHolder(holder: ReviewsItemViewHolder, position: Int) {
        val reviewsItem = reviewsItemList[position]
        holder.bind(reviewsItem)
        holder.binding.userProfileReviews.setOnClickListener {
            val intent = Intent(context,Book_home_page_Activity::class.java)
            intent.putExtra("name",reviewsItem.book_name)
            intent.putExtra("author",reviewsItem.book_author)
            val bitmap = BitmapFactory.decodeResource(context.resources,reviewsItem.book_png)
            val bs = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,bs)
            intent.putExtra("book_photo",bs.toByteArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return reviewsItemList.size
    }

}