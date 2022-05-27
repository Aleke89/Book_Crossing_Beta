package com.example.view_binding_tutorial.userratingfragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.userprofile.User_Profile_Activity
import com.example.view_binding_tutorial.databinding.UserratingItemLayoutBinding
import java.io.ByteArrayOutputStream


class UserRatingFragment_ItemAdapter (private val context: Context, private val userratingItemList:MutableList<UserRatingItem>,private val itemclick:RecyclerViewInterface):
    RecyclerView.Adapter<UserRatingFragment_ItemAdapter.UserItemViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = UserratingItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return UserItemViewHolder(binding, itemclick)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val userratingItem = userratingItemList[position]
        holder.bind(userratingItem)
        holder.binding.userRatingBackground.setOnClickListener {
            val intent = Intent(context, User_Profile_Activity::class.java)
            intent.putExtra("name",userratingItem.person_name)
            intent.putExtra("gmail",userratingItem.person_gmail)
            intent.putExtra("phone_number",userratingItem.phone_number)
            val bitmap = BitmapFactory.decodeResource(context.resources,userratingItem.person_img) // your bitmap
            val bs = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs)
            intent.putExtra("person_img", bs.toByteArray())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userratingItemList.size
    }
    class UserItemViewHolder(userratingItemLayoutBinding: UserratingItemLayoutBinding,ItemClick:RecyclerViewInterface)
        : RecyclerView.ViewHolder(userratingItemLayoutBinding.root){

        val binding = userratingItemLayoutBinding
        init {
            itemView.setOnClickListener{
                ItemClick.onItemClick(adapterPosition)
            }
        }
        fun bind(userratingItem: UserRatingItem){
            binding.userRatingName.text = userratingItem.person_name
            binding.userRatingProfession.text = userratingItem.profession
            binding.userRatingBookNumber.text = userratingItem.book_number
            binding.userRatingNoteNumber.text = userratingItem.review_number
            binding.userRatingStarNumber.text = userratingItem.star_number
            binding.userRatingPersonImg.setImageResource(userratingItem.person_img)
        }

    }

}