package com.example.view_binding_tutorial.bookfragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.databinding.BookItemLayoutBinding
import java.io.ByteArrayOutputStream

class BookFragment_ItemAdapter(private val context: Context, private val bookItemList:MutableList<BookItem>, private val itemclick: BookFragment):
    RecyclerView.Adapter<BookFragment_ItemAdapter.BookItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val binding = BookItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return BookItemViewHolder(binding,itemclick)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val bookItem = bookItemList[position]
        holder.bind(bookItem)
        holder.binding.bookBackground.setOnClickListener {
            val intent = Intent(context, Book_home_page_Activity::class.java)
            intent.putExtra("name",bookItem.name)
            intent.putExtra("author",bookItem.author_name)
            intent.putExtra("genre",bookItem.genre)
            intent.putExtra("amount",bookItem.amount)
            intent.putExtra("rating",bookItem.rating)

            intent.putExtra("book_photo", bookItem.book_img)
//            val bitmap = BitmapFactory.decodeResource(context.resources,bookItem.book_img) // your bitmap
//            val bs = ByteArrayOutputStream()
//            bitmap.compress(Bitmap.CompressFormat.JPEG,50,bs)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bookItemList.size
    }
    class BookItemViewHolder(bookItemLayoutBinding: BookItemLayoutBinding, ItemClick: BookFragment)
        : RecyclerView.ViewHolder(bookItemLayoutBinding.root){

         val binding = bookItemLayoutBinding
        init {
            itemView.setOnClickListener{
                ItemClick.onItemClickBook(adapterPosition)
            }
        }
        fun bind(bookItem: BookItem){
            binding.bookName.text = bookItem.name
            binding.bookAuthor.text = bookItem.author_name
            binding.bookImg.setImageResource(bookItem.book_img)
            binding.bookRating.rating = bookItem.rating
            binding.bookGenreName.text = bookItem.genre
            binding.bookInt.text = bookItem.amount
        }

    }
}
