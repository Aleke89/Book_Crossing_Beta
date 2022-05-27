package com.example.view_binding_tutorial.book_homepage.reviews

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.databinding.FragmentReviewsBhpItemLayoutBinding
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import java.io.ByteArrayOutputStream

class ReviewsItemAdapter(private val context: Context, private val readedItemList:MutableList<ReviewsItem>, private val itemClick: Reviews_Fragment_bhp):
    RecyclerView.Adapter<ReviewsItemAdapter.ReviewsItemViewHolder>() {
    class ReviewsItemViewHolder(FragmentReviewItemLayoutBinding:FragmentReviewsBhpItemLayoutBinding,ItemClick:Reviews_Fragment_bhp):
        RecyclerView.ViewHolder(FragmentReviewItemLayoutBinding.root) {
        val binding = FragmentReviewItemLayoutBinding
        init {
            itemView.setOnClickListener{
                ItemClick.onItemClickBook(adapterPosition)
            }
        }
        fun bind(readedItem: ReviewsItem) {
            binding.personName.text = readedItem.person_name
            binding.personText.text = readedItem.text
            binding.personImg.setImageResource(readedItem.person_img)
            binding.personRating.rating = readedItem.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsItemViewHolder {
        val binding = FragmentReviewsBhpItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ReviewsItemViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: ReviewsItemViewHolder, position: Int) {
        val readedItem = readedItemList[position]
        holder.bind(readedItem)
        holder.binding.personBackgrooun.setOnClickListener{
            val intent = Intent(context, User_Profile_Activity::class.java)
            intent.putExtra("name", readedItem.person_name)
            intent.putExtra("rating", readedItem.rating)
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
}